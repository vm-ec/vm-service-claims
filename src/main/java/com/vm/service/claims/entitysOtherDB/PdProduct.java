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
@Table(name = "PD_PRODUCT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PdProduct {


    @Id
    @Column(name = "PD_PRODUCT_ID", nullable = false)
    private Long pdProductId;

    @Column(name = "PD_PRODUCT_NAME", length = 100)
    private String pdProductName;

}
