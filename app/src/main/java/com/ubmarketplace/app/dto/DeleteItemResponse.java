package com.ubmarketplace.app.dto;

import com.ubmarketplace.app.model.User;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeleteItemResponse {
    private Boolean success;
}