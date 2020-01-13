package kim.zzang.webservice.web;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import kim.zzang.webservice.dto.member.MemberMainResponseDto;
import kim.zzang.webservice.dto.member.MemberSaveRequestDto;
import kim.zzang.webservice.service.MemberService;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = {"https://zzang.kim", "https://www.zzang.kim"})
public class MemberController {

    private MemberService memberService;

    @PostMapping("/api/member/insert")
    public void create(@RequestBody MemberSaveRequestDto dto) {
        memberService.join(dto);
    }

    @GetMapping("/api/member/list")
    public List<MemberMainResponseDto> list(){
        return memberService.findAllDesc();
    }


}


