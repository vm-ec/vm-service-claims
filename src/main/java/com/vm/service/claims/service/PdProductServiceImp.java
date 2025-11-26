package com.vm.service.claims.service;

import com.vm.service.claims.dtos.PdProductDto;
import com.vm.service.claims.entitys.PdDocumentVersion;
import com.vm.service.claims.entitys.PdProduct;
import com.vm.service.claims.entitysOtherDB.*;
import com.vm.service.claims.repositorys.*;
import com.vm.service.claims.repositorysOtherRepo.*;
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

    // ---------- H2 Repositories ----------
    @Autowired private PdProductRepository pdProductRepository;
    @Autowired private PdTransactionSetRepository pdTransactionSetRepository;
    @Autowired private PdTransactionSetValueRepository pdTransactionSetValueRepository;
    @Autowired private PdFilingRepository pdFilingRepository;
    @Autowired private PdDocumentRepository pdDocumentRepository;
    @Autowired private PdDocumentMemberRepository pdDocumentMemberRepository;
    @Autowired private PdDocumentVersionRepository pdDocumentVersionRepository;
    @Autowired private JurisdictionSetRepository jurisdictionSetRepository;
    @Autowired private JurisdictionSetValuesRepository jurisdictionSetValuesRepository;

    // ---------- Azure SQL Repositories ----------
    @Autowired private PdProductRepositoryAnother pdProductRepositoryAnother;
    @Autowired private PdTransactionSetRepositoryAnother pdTransactionSetRepositoryAnother;
    @Autowired private PdTransactionSetValueRepositoryAnother pdTransactionSetValueRepositoryAnother;
    @Autowired private PdFilingRepositoryAnother pdFilingRepositoryAnother;
    @Autowired private PdDocumentRepositoryAnother pdDocumentRepositoryAnother;
    @Autowired private PdDocumentMemberRepositoryAnother pdDocumentMemberRepositoryAnother;
    @Autowired private PdDocumentVersionRepositoryAnother pdDocumentVersionRepositoryAnother;
    @Autowired private JurisdictionSetRepositoryAnother jurisdictionSetRepositoryAnother;
    @Autowired private JurisdictionSetValuesRepositoryAnother jurisdictionSetValuesRepositoryAnother;


    public void syncDataH2toAzureSQL() {

        try {
            // 1. Fetch from H2 DB
            log.info("Start syncDocumentsToPostgres");
            log.info("Fetch from H2 DB");
            List<PdProduct> prods = pdProductRepository.findAll();
            List<com.vm.service.claims.entitysOtherDB.PdProduct> otherPdProduct = prods.stream()
                    .map(o -> mapper.map(o, com.vm.service.claims.entitysOtherDB.PdProduct.class))
                   .toList();
            pdProductRepositoryAnother.saveAll(otherPdProduct);

            // -------- JurisdictionSet --------
            List<com.vm.service.claims.entitys.JurisdictionSet> jsList = jurisdictionSetRepository.findAll();
            List<com.vm.service.claims.entitysOtherDB.JurisdictionSet> mappedJsList =
                    jsList.stream()
                            .map(e -> mapper.map(e, com.vm.service.claims.entitysOtherDB.JurisdictionSet.class))
                            .toList();
            jurisdictionSetRepositoryAnother.saveAll(mappedJsList);

            // -------- JurisdictionSetValues --------
            List<com.vm.service.claims.entitys.JurisdictionSetValues> jsvList = jurisdictionSetValuesRepository.findAll();
            List<com.vm.service.claims.entitysOtherDB.JurisdictionSetValues> mappedJsvList =
                    jsvList.stream()
                            .map(e -> mapper.map(e, com.vm.service.claims.entitysOtherDB.JurisdictionSetValues.class))
                            .toList();
            jurisdictionSetValuesRepositoryAnother.saveAll(mappedJsvList);

            // -------- PdTransactionSet --------
            List<com.vm.service.claims.entitys.PdTransactionSet> tsList = pdTransactionSetRepository.findAll();
            List<com.vm.service.claims.entitysOtherDB.PdTransactionSet> mappedTsList =
                    tsList.stream()
                            .map(e -> mapper.map(e, com.vm.service.claims.entitysOtherDB.PdTransactionSet.class))
                            .toList();
            pdTransactionSetRepositoryAnother.saveAll(mappedTsList);

            // -------- PdTransactionSetValue --------
            List<com.vm.service.claims.entitys.PdTransactionSetValue> tsvList = pdTransactionSetValueRepository.findAll();
            List<com.vm.service.claims.entitysOtherDB.PdTransactionSetValue> mappedTsvList =
                    tsvList.stream()
                            .map(e -> mapper.map(e, com.vm.service.claims.entitysOtherDB.PdTransactionSetValue.class))
                            .toList();
            pdTransactionSetValueRepositoryAnother.saveAll(mappedTsvList);

            // -------- PdFiling --------
            List<com.vm.service.claims.entitys.PdFiling> filingList = pdFilingRepository.findAll();
            List<com.vm.service.claims.entitysOtherDB.PdFiling> mappedFilingList =
                    filingList.stream()
                            .map(e -> mapper.map(e, com.vm.service.claims.entitysOtherDB.PdFiling.class))
                            .toList();
            pdFilingRepositoryAnother.saveAll(mappedFilingList);



            // -------- PdDocument --------
            List<com.vm.service.claims.entitys.PdDocument> documentList = pdDocumentRepository.findAll();
            List<com.vm.service.claims.entitysOtherDB.PdDocument> mappedDocList =
                    documentList.stream()
                            .map(e -> mapper.map(e, com.vm.service.claims.entitysOtherDB.PdDocument.class))
                            .toList();
            pdDocumentRepositoryAnother.saveAll(mappedDocList);

            // -------- PdDocumentMember --------
            List<com.vm.service.claims.entitys.PdDocumentMember> docMemberList = pdDocumentMemberRepository.findAll();
            List<com.vm.service.claims.entitysOtherDB.PdDocumentMember> mappedDocMemberList =
                    docMemberList.stream()
                            .map(e -> mapper.map(e, com.vm.service.claims.entitysOtherDB.PdDocumentMember.class))
                            .toList();
            pdDocumentMemberRepositoryAnother.saveAll(mappedDocMemberList);

            // -------- PdDocumentVersion --------
            List<PdDocumentVersion> docVersionList = pdDocumentVersionRepository.findAll();
            List<com.vm.service.claims.entitysOtherDB.PdDocumentVersion> mappedDocVersionList =
                    docVersionList.stream()
                            .map(e -> mapper.map(e, com.vm.service.claims.entitysOtherDB.PdDocumentVersion.class))
                            .toList();
            pdDocumentVersionRepositoryAnother.saveAll(mappedDocVersionList);



//            List<PdProductDto> PdProductDto = prods.stream()
//                    .map(p -> mapper.map(p, PdProductDto.class))
//                    .toList();
//            List<com.vm.service.claims.entitysOtherDB.PdProduct> otherPdProduct = PdProductDto.stream()
//                    .map(o -> mapper.map(o, com.vm.service.claims.entitysOtherDB.PdProduct.class))
//                    .toList();
//            log.info("Insert into AzureSQL");
            // 2. Insert into PostgreSQL
        //    insertIntoPostgres(otherPdProduct);
            //pdProductRepositoryAnother.saveAll(otherPdProduct);

            log.info("Insert into AzureSQL completed");

            //log.info("changed the sync_status in h2 completed");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //@Transactional("pgTransactionManager")
    @Transactional("sqlServerTransactionManager")
    public void insertIntoPostgres(List<com.vm.service.claims.entitysOtherDB.PdProduct> items) {
        pdProductRepositoryAnother.saveAll(items);

    }

    @Transactional("h2TransactionManager")
    public void updateSyncStatusInH2(List<Long> ids) {
        log.info("changing the sync_status in h2..");
        List<PdProduct> managed = pdProductRepository.findAllById(ids);
       // managed.forEach(p -> p.setSyncStatus("SUCCESS"));
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
