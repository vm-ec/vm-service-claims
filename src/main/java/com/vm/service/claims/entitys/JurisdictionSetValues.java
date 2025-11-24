package com.vm.service.claims.entitys;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "JURISDICTION_SET_VALUES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JurisdictionSetValues {

    @Id
    @Column(name = "JURISDICTION_SET_VALUES_ID", nullable = false)
    private Long jurisdictionSetValuesId;

    @Column(name = "JURISDICTION_ID", nullable = false)
    private Long jurisdictionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JURISDICTION_SET_ID", nullable = false)
    private JurisdictionSet jurisdictionSet;

    @Column(name = "JURISDICTION_SHORT_NAME", length = 100)
    private String jurisdictionShortName;

    @Column(name = "JURISDICTION_NAME", length = 100)
    private String jurisdictionName;

}
