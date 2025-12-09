package org.example.tuk_market_v2.item;

import lombok.RequiredArgsConstructor;
import org.example.tuk_market_v2.auth.AuthRepository;
import org.example.tuk_market_v2.item.dto.ItemCreateRequest;
import org.example.tuk_market_v2.item.dto.ItemResponse;
import org.example.tuk_market_v2.item.entity.Item;
import org.example.tuk_market_v2.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final AuthRepository authRepository;

    @Transactional
    public ItemResponse createItem(ItemCreateRequest request){
        User seller = authRepository.findById(request.getSellerId())
                .orElseThrow(() -> new IllegalArgumentException("정보가 없습니다."));

        Item item = Item.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .price(request.getPrice())
                .seller(seller)
                .build();

        Item saved = itemRepository.save(item);
        return ItemResponse.from(saved);
    }

    @Transactional(readOnly = true)
    public ItemResponse getItem(Long id){
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("정보가 없습니다."));

        return ItemResponse.from(item);
    }

    @Transactional(readOnly = true)
    public Page<ItemResponse> getItems(Pageable pageable){
        return itemRepository.findAllByOrderByCreatedAtDesc(pageable)
                .map(ItemResponse::from);
    }
}
