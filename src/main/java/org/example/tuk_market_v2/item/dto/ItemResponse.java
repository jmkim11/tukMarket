package org.example.tuk_market_v2.item.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.tuk_market_v2.item.entity.Item;

import java.time.LocalDateTime;

@Getter@Setter
@AllArgsConstructor
@Builder
public class ItemResponse {
    private Long id;
    private String title;
    private String description;
    private Integer price;
    private Long sellerId;
    private String sellerNickName;
    private LocalDateTime createdAt;

    public static ItemResponse from(Item item){
        return ItemResponse.builder()
                .id(item.getId())
                .title(item.getTitle())
                .description(item.getDescription())
                .price(item.getPrice())
                .sellerId(item.getSeller().getId())
                .sellerNickName(item.getSeller().getUsername())
                .createdAt(item.getCreatedAt())
                .build();
    }
}
