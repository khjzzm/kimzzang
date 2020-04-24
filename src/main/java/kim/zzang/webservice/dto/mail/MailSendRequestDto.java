package kim.zzang.webservice.dto.mail;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MailSendRequestDto {
    private String address;
    private String kakaotalk;
    private String message;

    @Builder
    public MailSendRequestDto(String address, String kakaotalk, String message) {
        this.address = address;
        this.kakaotalk = kakaotalk;
        this.message = message;
    }
}