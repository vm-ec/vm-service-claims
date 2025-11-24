package com.vm.service.claims.controllers;

import com.vm.service.claims.dtos.PdProductDto;
import com.vm.service.claims.service.PdProductServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class PdProductController {

    private final PdProductServiceImp pdProductService;

    public PdProductController(PdProductServiceImp pdProductService) {
        this.pdProductService = pdProductService;
    }

    // Create
    @PostMapping("/create")
    public ResponseEntity<PdProductDto> createProduct(@RequestBody PdProductDto product) {
        PdProductDto saved = pdProductService.saveProduct(product);
        return ResponseEntity.ok(saved);
    }

    // Get all
    @GetMapping("/findall")
    public ResponseEntity<List<PdProductDto>> getAllProducts() {
        return ResponseEntity.ok(pdProductService.getAllProducts());
    }

    // Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<PdProductDto> getProductById(@PathVariable Long id) {
        PdProductDto product = pdProductService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<PdProductDto> updateProduct(
            @PathVariable Long id,
            @RequestBody PdProductDto updated) {

        PdProductDto result = pdProductService.updateProduct(id, updated);
        return ResponseEntity.ok(result);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        pdProductService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
