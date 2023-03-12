package com.works.mapstruct.springmapstructdemo.repository;

import com.works.mapstruct.springmapstructdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}