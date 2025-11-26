package com.vm.service.claims.entitysOtherDB;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
