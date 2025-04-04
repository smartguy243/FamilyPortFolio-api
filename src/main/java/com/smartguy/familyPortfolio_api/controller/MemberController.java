package com.smartguy.familyPortfolio_api.controller;

import com.smartguy.familyPortfolio_api.playload.rq.MemberRq;
import com.smartguy.familyPortfolio_api.playload.rs.MemberRs;
import com.smartguy.familyPortfolio_api.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public List<MemberRs> getAllMembers(){
        return memberService.getAllMembers();
    }

    @GetMapping("/{memberId}")
    public MemberRs getOneMember(@PathVariable UUID memberId){
        return memberService.getMemberById(memberId);
    }

    @PostMapping
    public MemberRs createMember(@RequestBody MemberRq memberRq){
        return memberService.createMember(memberRq);
    }

    @PutMapping("/{memberId}")
    public MemberRs updateMember(@PathVariable UUID memberId, @RequestBody @Valid MemberRq memberRq){
        return memberService.updateMember(memberRq, memberId);
    }

    @DeleteMapping("/{memberId}")
    public String deleteMember(@PathVariable UUID memberId){
        return memberService.deleteMember(memberId);
    }
}
