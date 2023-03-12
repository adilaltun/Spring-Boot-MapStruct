package com.works.mapstruct.springmapstructdemo.mapper;

import com.works.mapstruct.springmapstructdemo.dto.ProductDto;
import com.works.mapstruct.springmapstructdemo.model.Product;
import com.works.mapstruct.springmapstructdemo.validator.ProductValidationException;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper(uses = {ProductValidator.class},componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "product.desc", target = "description", defaultValue = "description")
    /*@Mapping(target = "itemId",expression = "java(UUID.randomUUID().toString())")
    @Mapping(source = "product.items",target = "itemsList")*/
    ProductDto modelDto (Product product) throws ProductValidationException;

    List<ProductDto> modelsDto (List<Product> product);

    //@Mapping(source = "productDto.description",target="desc",defaultValue = "description")
    @InheritInverseConfiguration
    Product dtoModel (ProductDto productDto) throws ProductValidationException;

}
