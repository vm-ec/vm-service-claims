package com.vm.service.claims.repositorys;

import com.vm.service.claims.entitys.PdProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PdProductRepository extends JpaRepository<PdProduct,Long> {

    @Query(
            value = "SELECT * FROM pd_product WHERE sync_status <> 'SUCCESS' OR sync_status IS NULL",
            nativeQuery = true
    )
    List<PdProduct> findNotSyncedProducts();

}
