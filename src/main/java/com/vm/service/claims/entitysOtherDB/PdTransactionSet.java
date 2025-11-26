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
@Table(name = "PD_TRANSACTION_SET")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PdTransactionSet {

    @Id
    @Column(name = "PD_TRANSACTION_SET_ID", nullable = false)
    private Long pdTransactionSetId;

    @Column(name = "PD_TRANSACTION_SET_NAME", length = 100)
    private String pdTransactionSetName;
}
