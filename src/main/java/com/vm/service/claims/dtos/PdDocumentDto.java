package com.vm.service.claims.dtos;

import lombok.Data;

@Data
public class PdDocumentDto {


    private Long pdDocumentId;
    private String documentContentType;
    private String pdDocumentName;
    private String objectType;
    private Long selectedConditionRuleId;

    private String deletePriorTf;
    private String variableDataTf;
    private String includeTf;

    private Long pdTransactionSetId;
    private Long jurisdictionSetId;
    private Long pdProductId;

    private Long pdFilingId;
    private Long lastPdFilingId;

    private String packageTf;
    private String outputFileType;
    private String coveredObjectType;

}
