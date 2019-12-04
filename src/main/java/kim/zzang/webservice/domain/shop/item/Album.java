package kim.zzang.webservice.domain.shop.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by holyeye on 2014. 3. 11..
 */

@Entity
@DiscriminatorValue("A")
public class Album extends Item {

    private String artist;
    private String etc;
}