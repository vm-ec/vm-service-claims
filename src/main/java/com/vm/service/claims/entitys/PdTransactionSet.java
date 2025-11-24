package com.vm.service.claims.entitys;

import jakarta.persistence.*;
import lombok.*;


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
