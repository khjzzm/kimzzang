package kim.zzang.webservice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kim.zzang.webservice.dto.item.ItemSaveRequestDto;
import kim.zzang.webservice.repository.ItemRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Transactional
public class ItemService{

    private ItemRepository itemRepository;

    public Long saveItem(ItemSaveRequestDto dto){
        return itemRepository.save(dto.toEntity()).getId();
    }

}