package com.smartguy.familyPortfolio_api.playload.rs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class MemberRs {

    private UUID id;
    private String firstName;
    private String lastName;
}
