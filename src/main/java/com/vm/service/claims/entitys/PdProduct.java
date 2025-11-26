package com.vm.service.claims.entitys;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "PD_PRODUCT_NAME",nullable = false, length = 100)
    private String pdProductName;

}
