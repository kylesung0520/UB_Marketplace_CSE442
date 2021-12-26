package com.ubmarketplace.app.dto;

import lombok.*;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeleteItemRequest {

    @NotNull(message = "itemID cannot be empty")
    private String itemID;

    @NotNull(message = "userID cannot be empty")
    private String userId;
}