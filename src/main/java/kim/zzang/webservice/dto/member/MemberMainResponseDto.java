package kim.zzang.webservice.dto.member;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import lombok.Getter;
import lombok.NoArgsConstructor;

import kim.zzang.webservice.domain.shop.Address;
import kim.zzang.webservice.domain.shop.Member;

@Getter
@NoArgsConstructor
public class MemberMainResponseDto {

    private Long id;
    private String name;
    private Address address;
    private String modifiedDate;

    public MemberMainResponseDto(Member entity){
        id = entity.getId();
        name = entity.getName();
        address = entity.getAddress();
        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }

    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                    .map(formatter::format)
                    .orElse("");
    }
}