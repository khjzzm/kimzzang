package kim.zzang.webservice.web;

import kim.zzang.webservice.dto.mail.MailSendRequestDto;
import kim.zzang.webservice.service.MailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@Controller
@RestController
@AllArgsConstructor
@CrossOrigin(origins = {"*"})
public class MailController {
    private final MailService mailService;

    @PostMapping("/api/send-mail")
    public void sendMail(@RequestBody MailSendRequestDto mailSendRequestDto) {
        log.info("mailSendRequestDto", mailSendRequestDto);
        mailService.sendMail(mailSendRequestDto);
    }
}