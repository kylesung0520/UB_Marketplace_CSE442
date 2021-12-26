package com.ubmarketplace.app.controller;

import com.ubmarketplace.app.dto.DeleteItemRequest;
import com.ubmarketplace.app.model.Item;
import com.ubmarketplace.app.model.User;
import com.ubmarketplace.app.repository.ItemRepository;
import com.ubmarketplace.app.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.security.InvalidParameterException;

import static com.ubmarketplace.app.TestStatic.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class DeleteItemControllerTest {
    @Autowired
    DeleteItemController deleteItemController;



    @BeforeAll
    static void setup(@Autowired ItemRepository itemRepository, @Autowired UserRepository userRepository) {
        userRepository.insert(User.builder().userId(TEST_USER_ID_3).password(TEST_PASSWORD_3).build());
        userRepository.insert(User.builder().userId(TEST_USER_ID_1).password(TEST_PASSWORD_1).build());
        userRepository.insert(User.builder().userId(TEST_USER_ID_2).password(TEST_PASSWORD_2).role("Admin").build());
        itemRepository.insert(Item.builder().itemId(TEST_ITEM_ID_1).name(TEST_ITEM_NAME_1).userId(TEST_USER_ID_1).build());
        itemRepository.insert(Item.builder().itemId(TEST_ITEM_ID_2).name(TEST_ITEM_NAME_2).userId(TEST_USER_ID_2).build());
        itemRepository.insert(Item.builder().itemId(TEST_ITEM_ID_3).name(TEST_ITEM_NAME_3).userId(TEST_USER_ID_3).build());
    }

    @Test
    void DeleteItemByID_THEN_return_True() {
        String response = deleteItemController.delete(new DeleteItemRequest(TEST_ITEM_ID_1, TEST_USER_ID_1));
        Assertions.assertEquals(response, "success");
    }

    @Test
    void DeleteItemByWrongID_THEN_return_False() {
        Assertions.assertThrows(InvalidParameterException.class, () -> deleteItemController.delete(new DeleteItemRequest("123", TEST_USER_ID_1)));
    }

    @Test
    public void DeleteItem_withAdmin_THEN_returnTrue() {
        String response = deleteItemController.delete(new DeleteItemRequest(TEST_ITEM_ID_3, TEST_USER_ID_2));
        Assertions.assertEquals(response, "success");
    }




}