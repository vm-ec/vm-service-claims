package com.vm.service.claims.repositorysOtherRepo;


import com.vm.service.claims.entitysOtherDB.PdProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdProductRepositoryAnother extends JpaRepository<PdProduct,Long> {
}
