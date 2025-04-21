package com.smartguy.familyPortfolio_api.entity;

import com.smartguy.familyPortfolio_api.playload.rs.MemberRs;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {

    @Id
    @UuidGenerator
    private UUID id;
    private String firstName;
    private String lastName;

    public MemberRs toMemberRs(){
        return MemberRs.builder()
                .id(this.getId())
                .firstName(this.getFirstName())
                .lastName(this.getLastName())
                .build();
    }
}
