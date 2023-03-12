package com.works.mapstruct.springmapstructdemo.controller;

import com.works.mapstruct.springmapstructdemo.dto.ProductDto;
import com.works.mapstruct.springmapstructdemo.mapper.ProductMapper;
import com.works.mapstruct.springmapstructdemo.model.Product;
import com.works.mapstruct.springmapstructdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<Product> save(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productRepository.save(
                productMapper.dtoModel(productDto)),HttpStatus.CREATED);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductDto>> findAll(){
        return new ResponseEntity<>(productMapper.modelsDto(productRepository.findAll()),HttpStatus.OK);
    }

    @GetMapping("/products/{id]")
    public ResponseEntity<ProductDto> finbById(@PathVariable(value = "id")  Integer id){
        return new ResponseEntity<>(productMapper.modelDto(productRepository.findById(id).get()),HttpStatus.OK);
    }

    @DeleteMapping("/deleteProducts/{id]")
    public ResponseEntity<ProductDto> deleteById(@PathVariable(value = "id")  Integer id){
        ProductDto productDto = productMapper.modelDto(productRepository.findById(id).get());

        productRepository.deleteById(productDto.getProductId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
