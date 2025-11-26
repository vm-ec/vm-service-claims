package com.vm.service.claims.entitysOtherDB;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PD_DOCUMENT_MEMBER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PdDocumentMember {

    @Id
    @Column(name = "PD_DOCUMENT_MEMBER_ID", nullable = false)
    private Long pdDocumentMemberId;

    // MASTER_PD_DOCUMENT_ID → PD_DOCUMENT(PD_DOCUMENT_ID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MASTER_PD_DOCUMENT_ID", nullable = true)
    private PdDocument masterPdDocument;

    // DETAIL_PD_DOCUMENT_ID → PD_DOCUMENT(PD_DOCUMENT_ID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DETAIL_PD_DOCUMENT_ID", nullable = true)
    private PdDocument detailPdDocument;

    // PD_PRODUCT_ID → PD_PRODUCT(PD_PRODUCT_ID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PD_PRODUCT_ID", nullable = true)
    private PdProduct pdProduct;

    // PD_FILING_ID → PD_FILING(PD_FILING_ID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PD_FILING_ID")
    private PdFiling pdFiling;

    // LAST_PD_FILING_ID → PD_FILING(PD_FILING_ID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LAST_PD_FILING_ID")
    private PdFiling lastPdFiling;
}
