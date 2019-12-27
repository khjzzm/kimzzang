package kim.zzang.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import kim.zzang.webservice.domain.shop.item.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}