package kim.zzang.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import kim.zzang.webservice.domain.shop.Member;
import kim.zzang.webservice.dto.member.MemberMainResponseDto;
import kim.zzang.webservice.dto.member.MemberSaveRequestDto;
import kim.zzang.webservice.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class MemberService {

    private MemberRepository memberRepository;

    @Transactional
    public List<MemberMainResponseDto> findAllDesc(){
        return memberRepository.findAllDesc()
            .map(MemberMainResponseDto::new)
            .collect(Collectors.toList());
    }


    @Transactional
    public Long join(MemberSaveRequestDto dto) {
//        validateDuplicateMember(dto);
        return memberRepository.save(dto.toEntity()).getId();
    }

    private void validateDuplicateMember(MemberSaveRequestDto member){
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}