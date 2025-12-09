package org.example.tuk_market_v2.item.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.tuk_market_v2.user.entity.User;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer price;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;


    public static Item to(String title,
                          String description,
                          Integer price,
                          User seller){

        return Item.builder()
                .title(title)
                .description(description)
                .price(price)
                .seller(seller)
                .build();

    }
}
