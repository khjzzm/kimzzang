package kim.zzang.webservice.dto.item;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import kim.zzang.webservice.domain.shop.Category;
import kim.zzang.webservice.domain.shop.item.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemSaveRequestDto {

    private String name;
    private int price;
    private int stockQuantity;
    private List<Category> category;

    @Builder
    public ItemSaveRequestDto(String name, int price, int stockQuantity, List<Category> categories){
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity; 
        this.category = categories;
    }

    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                    .map(formatter::format)
                    .orElse("");
    }

    public Item toEntity(){
        return Item.builder()
                    .name(name)
                    .price(price)
                    .stockQuantity(stockQuantity)
                    .categories(category)
                    .build();
    }
}
