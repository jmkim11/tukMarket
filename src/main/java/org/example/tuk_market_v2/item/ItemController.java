package org.example.tuk_market_v2.item;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.tuk_market_v2.item.dto.ItemCreateRequest;
import org.example.tuk_market_v2.item.dto.ItemResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
@Tag(name = "Item", description = "아이템 생성/조회 관련 API")
public class ItemController {

    private final ItemService itemService;

    @Operation(summary = "생성", description = "아이템 이미지, 제목, 가격, 내용을 입력해 거래를 올립니다.")
    @PostMapping
    public ItemResponse createItem(@RequestBody ItemCreateRequest request){
        return itemService.createItem(request);
    }

    @Operation(summary = "단일 조회", description = "거래 품목의 상세 정보를 출력합니다.")
    @GetMapping("/{id}")
    public ItemResponse getItem(@PathVariable Long id){
        return itemService.getItem(id);
    }

    @Operation(summary = "모든 아이템 조회", description = "거래 품목을 모두 출력합니다.")
    @GetMapping
    public Page<ItemResponse> getItems(Pageable pageable){
        return itemService.getItems(pageable);
    }
}
