package com.vm.service.claims.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PdProductDto {

    private Long pdProductId;
    private String pdProductName;
    private String syncStatus;

    public PdProductDto(Long pdProductId, String pdProductName) {
        this.pdProductId = pdProductId;
        this.pdProductName = pdProductName;
    }

    public PdProductDto(Long pdProductId, String pdProductName, String syncStatus) {
        this.pdProductId = pdProductId;
        this.pdProductName = pdProductName;
        this.syncStatus = syncStatus;
    }
}
