package com.vm.service.claims.entitys;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "PD_FILING")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PdFiling {

    @Id
    @Column(name = "PD_FILING_ID", nullable = false)
    private Long pdFilingId;

    // FK → PD_PRODUCT(PD_PRODUCT_ID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PD_PRODUCT_ID")
    private PdProduct pdProduct;

    @Column(name = "PD_FILING_NAME", length = 100)
    private String pdFilingName;

    @Column(name = "PD_FILING_DATE")
    @Temporal(TemporalType.DATE)
    private Date pdFilingDate;

    @Column(name = "RENEWAL_EFFECTIVE_DATE")
    @Temporal(TemporalType.DATE)
    private Date renewalEffectiveDate;
}
