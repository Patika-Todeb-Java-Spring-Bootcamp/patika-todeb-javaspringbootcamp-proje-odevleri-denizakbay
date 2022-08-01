package org.patika.advertproject.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.patika.advertproject.model.Currency;
import org.patika.advertproject.model.entity.Address;
import org.patika.advertproject.model.entity.Category;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class AdvertDTO {


    private String title;
    private String description;

    private List<Category> category;
    private Integer no;
    private Double price;
    private Currency priceCurrency = Currency.TL;
    private Address address;
    private LocalDateTime startDate = LocalDateTime.now();
    private Integer room;
    private Integer sqm;
    private Integer floorCount;
    private Integer age;

}
