package com.smartguy.familyPortfolio_api.playload.rq;

import com.smartguy.familyPortfolio_api.entity.Member;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@Builder
public class MemberRq {

    private UUID id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String name;

    public static Member toMember(MemberRq memberRq){
        return Member.builder()
                .id(memberRq.getId())
                .firstName(memberRq.getFirstName())
                .name(memberRq.getName())
                .build();
    }
}
