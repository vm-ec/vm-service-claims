package com.vm.service.claims.service;

import com.vm.service.claims.dtos.PdProductDto;
import com.vm.service.claims.entitys.PdProduct;
import com.vm.service.claims.repositorys.PdProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PdProductServiceImp {

    @Autowired
    private ModelMapper mapper;

    private final PdProductRepository pdProductRepository;

    public PdProductServiceImp(PdProductRepository pdProductRepository) {
        this.pdProductRepository = pdProductRepository;
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
