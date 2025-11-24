package com.vm.service.claims.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PD_DOCUMENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PdDocument {

    @Id
    @Column(name = "PD_DOCUMENT_ID", nullable = false)
    private Long pdDocumentId;

    @Column(name = "DOCUMENT_CONTENT_TYPE", length = 500, nullable = false)
    private String documentContentType;

    @Column(name = "PD_DOCUMENT_NAME", length = 500)
    private String pdDocumentName;

    @Column(name = "OBJECT_TYPE", length = 500, nullable = false)
    private String objectType;

    @Column(name = "SELECTED_CONDITION_RULE_ID")
    private Long selectedConditionRuleId;

    @Column(name = "DELETE_PRIOR_TF", length = 1)
    private String deletePriorTf;

    @Column(name = "VARIABLE_DATA_TF", length = 1)
    private String variableDataTf;

    @Column(name = "INCLUDE_TF", length = 1)
    private String includeTf;

    // FK: PD_TRANSACTION_SET_ID → PD_TRANSACTION_SET
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PD_TRANSACTION_SET_ID", nullable = true)
    private PdTransactionSet pdTransactionSet;

    // FK: JURISDICTION_SET_ID → JURISDICTION_SET
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JURISDICTION_SET_ID", nullable = true)
    private JurisdictionSet jurisdictionSet;

    // FK: PD_PRODUCT_ID → PD_PRODUCT
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PD_PRODUCT_ID", nullable = true)
    private PdProduct pdProduct;

    // FK: PD_FILING_ID → PD_FILING
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PD_FILING_ID",nullable = true)
    private PdFiling pdFiling;

    // FK: LAST_PD_FILING_ID → PD_FILING
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LAST_PD_FILING_ID", nullable = true)
    private PdFiling lastPdFiling;

    @Column(name = "PACKAGE_TF", length = 1)
    private String packageTf;

    @Column(name = "OUTPUT_FILE_TYPE", length = 500, nullable = true)
    private String outputFileType;

    @Column(name = "COVERED_OBJECT_TYPE", length = 500)
    private String coveredObjectType;
}
