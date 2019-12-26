package kim.zzang.webservice.domain.shop;

import kim.zzang.webservice.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name="Member")
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "name")
    private String name;

//    private String city;
//    private String street;
//    private String zipcode;

    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "city", column = @Column(name = "home_city")),
//            @AttributeOverride(name = "street", column = @Column(name = "home_street")),
//            @AttributeOverride(name = "zipcode", column = @Column(name = "home_zipcode"))
//    })
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<Order>();

    @Builder
    public Member(Long id, String name, Address address){
        this.id = id;
        this.name = name;
        this.address = address;
    }
}