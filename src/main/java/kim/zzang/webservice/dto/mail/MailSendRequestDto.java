package kim.zzang.webservice.dto.mail;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MailSendRequestDto {
    private String name;
    private String kakaotalk;
    private String message;

    @Builder
    public MailSendRequestDto(String name, String kakaotalk, String message) {
        this.name = name;
        this.kakaotalk = kakaotalk;
        this.message = message;
    }
}