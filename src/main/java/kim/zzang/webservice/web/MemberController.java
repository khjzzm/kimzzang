package kim.zzang.webservice.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kim.zzang.webservice.dto.member.MemberSaveRequestDto;
import kim.zzang.webservice.service.MemberService;

@AllArgsConstructor
@RestController
public class MemberController {

    private MemberService memberService;

    @PostMapping("/api/member/insert")
    public void create(@RequestBody MemberSaveRequestDto dto){
        memberService.join(dto);
    }

}


