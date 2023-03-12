package com.works.mapstruct.springmapstructdemo.dto;

import com.works.mapstruct.springmapstructdemo.model.Item;
import lombok.Data;


import javax.persistence.Id;
import java.util.List;

@Data
public class ProductDto {
    @Id
    private int productId;

    private String name;
    private String description;
    private String quantitY;
    private long price;
    private String itemId;
    private List<Item> itemsList;

}
