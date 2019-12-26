package kim.zzang.webservice.dto.member;

import kim.zzang.webservice.domain.shop.Address;
import kim.zzang.webservice.domain.shop.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberSaveRequestDto {
    private String name;
    private Address address;

    @Builder
    public MemberSaveRequestDto(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Member toEntity() {
        return Member.builder().name(name).address(address).build();
    }
}
