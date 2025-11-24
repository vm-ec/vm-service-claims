package com.vm.service.claims.repositorys;

import com.vm.service.claims.entitys.PdProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdProductRepository extends JpaRepository<PdProduct,Long> {
}
