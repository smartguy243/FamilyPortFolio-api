package com.smartguy.familyPortfolio_api.service;

import com.smartguy.familyPortfolio_api.entity.Member;
import com.smartguy.familyPortfolio_api.exception.MemberNotFoundException;
import com.smartguy.familyPortfolio_api.playload.rq.MemberRq;
import com.smartguy.familyPortfolio_api.playload.rs.MemberRs;
import com.smartguy.familyPortfolio_api.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public List<MemberRs> getAllMembers(){
        return memberRepository.findAll().stream().map(Member::toMemberRs).toList();
    }

    public MemberRs getMemberById(UUID memberID){
        return memberRepository.findById(memberID)
                .orElseThrow(()-> new MemberNotFoundException(
                        String.format("User with id %s", memberID))).toMemberRs();
    }

    public MemberRs createMember (MemberRq memberRq){
        return memberRepository.save(MemberRq.toMember(memberRq)).toMemberRs();
    }

    public MemberRs updateMember(MemberRq memberInput, UUID memberId) {
        Member existingMember = memberRepository.findById(memberId)
                .orElseThrow(()-> new MemberNotFoundException(
                        String.format("User with id %s", memberId)));
        existingMember.setFirstName(memberInput.getFirstName());
        existingMember.setName(memberInput.getName());
        return memberRepository.save(existingMember).toMemberRs();
    }

    public String deleteMember(UUID memberId){
        memberRepository.deleteById(memberId);
        return "Member deleted !";
    }
}
