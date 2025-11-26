package com.vm.service.claims.entitysOtherDB;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "PD_DOCUMENT_VERSION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PdDocumentVersion {


    @Id
    @Column(name = "PD_DOCUMENT_VERSION_ID", nullable = false)
    private Long pdDocumentVersionId;

    // FK → PD_DOCUMENT(PD_DOCUMENT_ID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PD_DOCUMENT_ID", nullable = true)
    private PdDocument pdDocument;

    @Column(name = "PD_DOCUMENT_CODE", length = 50)
    private String pdDocumentCode;

    @Column(name = "PD_DOCUMENT_DESC", length = 500)
    private String pdDocumentDesc;

    @Column(name = "TEMPLATE_FILENAME", length = 500)
    private String templateFilename;

    @Column(name = "DISPLAY_NAME", length = 500)
    private String displayName;

    // FK → PD_PRODUCT(PD_PRODUCT_ID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PD_PRODUCT_ID", nullable = true)
    private PdProduct pdProduct;

    // FK → PD_FILING(PD_FILING_ID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PD_FILING_ID")
    private PdFiling pdFiling;

    // FK → PD_FILING(PD_FILING_ID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LAST_PD_FILING_ID")
    private PdFiling lastPdFiling;

    @Column(name = "PD_DOCUMENT_EDITION_DATE")
    @Temporal(TemporalType.DATE)
    private Date pdDocumentEditionDate;

    // FK → JURISDICTION_SET(JURISDICTION_SET_ID)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JURISDICTION_SET_ID")
    private JurisdictionSet jurisdictionSet;
}

