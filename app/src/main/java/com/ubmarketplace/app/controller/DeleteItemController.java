package com.ubmarketplace.app.controller;

import com.ubmarketplace.app.dto.*;
import com.ubmarketplace.app.manager.ItemManager;
import com.ubmarketplace.app.manager.UserManager;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Log
public class DeleteItemController {
    final UserManager userManager;
    final ItemManager itemManager;

    @Autowired
    public DeleteItemController(UserManager userManager, ItemManager itemManager) {
        this.userManager = userManager;
        this.itemManager = itemManager;
    }

    @RequestMapping(value = "/api/deleteitem", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    public String delete(@RequestBody DeleteItemRequest deleteItemRequest){

        if (itemManager.deleteItem(deleteItemRequest.getItemID(), deleteItemRequest.getUserId(), userManager)){
            return "success";
        }
        else{
            return "fail";
        }
    }

}
