package org.example.tuk_market_v2.item.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemCreateRequest {
    private String title;
    private String description;
    private Integer price;
    private Long sellerId;

}
