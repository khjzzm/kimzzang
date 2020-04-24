package kim.zzang.webservice.service;

import kim.zzang.webservice.dto.mail.MailSendRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailService {
    private JavaMailSender mailSender;
    private static final String ADDRESS = "khjzzm@gmail.com";

    public void sendMail(MailSendRequestDto mailSendRequestDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(MailService.ADDRESS);
        message.setTo(MailService.ADDRESS);
        message.setSubject(mailSendRequestDto.getKakaotalk());
        message.setText(mailSendRequestDto.getMessage());

        mailSender.send(message);
    }
}
