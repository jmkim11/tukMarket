package org.example.tuk_market_v2.item;

import org.example.tuk_market_v2.item.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Page<Item> findAllByOrderByCreatedAtDesc(Pageable pageable);
}
