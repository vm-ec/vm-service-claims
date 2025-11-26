package com.vm.service.claims.entitysOtherDB;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PD_TRANSACTION_SET_VALUE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PdTransactionSetValue {

    @Id
    @Column(name = "PD_TRANSACTION_SET_VALUE_ID", nullable = false)
    private Long pdTransactionSetValueId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PD_TRANSACTION_SET_ID")
    private PdTransactionSet pdTransactionSet;

    @Column(name = "PD_TRANSACTION_TYPE_ID")
    private Long pdTransactionTypeId;

    @Column(name = "PD_TRANSACTION_TYPE_NAME", length = 100)
    private String pdTransactionTypeName;

}
