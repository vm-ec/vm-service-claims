package com.vm.service.claims.service;

import com.vm.service.claims.dtos.PdProductDto;
import com.vm.service.claims.entitys.PdProduct;
import com.vm.service.claims.repositorys.PdProductRepository;
import com.vm.service.claims.repositorysOtherRepo.PdProductRepositoryAnother;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class PdProductServiceImp {

    @Autowired
    private ModelMapper mapper;

    private final PdProductRepository pdProductRepository;
    private final PdProductRepositoryAnother pdProductRepositoryAnother;



    public PdProductServiceImp(PdProductRepository pdProductRepository, PdProductRepositoryAnother pdProductRepositoryAnother) {
        this.pdProductRepository = pdProductRepository;
        this.pdProductRepositoryAnother = pdProductRepositoryAnother;
    }


    public void syncDocumentsToPostgres() {

        try {
            // 1. Fetch from H2 DB
            log.info("Start syncDocumentsToPostgres");
            log.info("Fetch from H2 DB");
            List<PdProduct> prods = pdProductRepository.findNotSyncedProducts();

            List<PdProductDto> PdProductDto = prods.stream()
                    .map(p -> mapper.map(p, PdProductDto.class))
                    .toList();
            List<com.vm.service.claims.entitysOtherDB.PdProduct> otherPdProduct = PdProductDto.stream()
                    .map(o -> mapper.map(o, com.vm.service.claims.entitysOtherDB.PdProduct.class))
                    .toList();
            log.info("Insert into PostgreSQL");
            // 2. Insert into PostgreSQL
            insertIntoPostgres(otherPdProduct);
            //pdProductRepositoryAnother.saveAll(otherPdProduct);

            log.info("Insert into PostgreSQL completed");
            //changing the sync_status
            updateSyncStatusInH2(
                    prods.stream().map(PdProduct::getPdProductId).toList()
            );
            log.info("changed the sync_status in h2 completed");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Transactional("sqlServerTransactionManager")
    public void insertIntoPostgres(List<com.vm.service.claims.entitysOtherDB.PdProduct> items) {
        pdProductRepositoryAnother.saveAll(items);
    }

    @Transactional("h2TransactionManager")
    public void updateSyncStatusInH2(List<Long> ids) {
        log.info("changing the sync_status in h2..");
        List<PdProduct> managed = pdProductRepository.findAllById(ids);
        managed.forEach(p -> p.setSyncStatus("SUCCESS"));
        pdProductRepository.saveAll(managed);
    }


    public PdProductDto saveProduct(PdProductDto productDto) {

        PdProduct pdp =mapper.map(productDto, PdProduct.class);
        PdProduct save = pdProductRepository.save(pdp);
        PdProductDto mapDto = mapper.map(save, PdProductDto.class);
        return  mapDto;
    }

    public List<PdProductDto> getAllProducts() {
        List<PdProduct> products = pdProductRepository.findAll();
        return products.stream()
                .map(product -> mapper.map(product, PdProductDto.class))
                .collect(Collectors.toList());
    }

    public PdProductDto getProductById(Long id) {
        PdProduct product = pdProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        return mapper.map(product, PdProductDto.class);
    }

    public PdProductDto updateProduct(Long id, PdProductDto updated) {
        PdProduct existing = pdProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found: " + id));

        existing.setPdProductName(updated.getPdProductName());

        PdProduct saved = pdProductRepository.save(existing);
        return mapper.map(saved, PdProductDto.class);
    }

    public void deleteProduct(Long id) {
        if (!pdProductRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        pdProductRepository.deleteById(id);
    }
}
