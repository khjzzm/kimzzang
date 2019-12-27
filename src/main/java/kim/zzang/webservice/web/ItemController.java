package kim.zzang.webservice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import kim.zzang.webservice.dto.item.ItemSaveRequestDto;
import kim.zzang.webservice.service.ItemService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ItemController{

    private ItemService itemService;

    @PostMapping(value = "/api/item/insert")
    public void create(@RequestBody ItemSaveRequestDto dto) {
        itemService.saveItem(dto);
    }

}