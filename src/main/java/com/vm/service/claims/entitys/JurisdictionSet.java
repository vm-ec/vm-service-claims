package com.vm.service.claims.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "JURISDICTION_SET")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JurisdictionSet {

    @Id
    @Column(name = "JURISDICTION_SET_ID", nullable = false)
    private Long jurisdictionSetId;

    @Column(name = "JURISDICTION_SET_NAME", length = 100)
    private String jurisdictionSetName;

    @Column(name = "JURISDICTION_SET_DESC", length = 500)
    private String jurisdictionSetDesc;
}
