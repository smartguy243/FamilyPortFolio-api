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
    private String firstName;
    private String lastName;

    public static Member toMember(MemberRq memberRq){
        return Member.builder()
                .id(memberRq.getId())
                .firstName(memberRq.getFirstName())
                .lastName(memberRq.getLastName())
                .build();
    }
}
