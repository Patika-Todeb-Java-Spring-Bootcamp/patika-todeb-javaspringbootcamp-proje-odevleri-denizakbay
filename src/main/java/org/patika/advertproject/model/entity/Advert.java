package org.patika.advertproject.model.entity;


import lombok.Getter;
import lombok.Setter;
import org.patika.advertproject.model.Currency;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @OneToMany
    private List<Category> category;
    private Integer no;
    private Double price;
    private Currency priceCurrency;
    @OneToOne
    private Address address;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer room;
    private Integer sqm;
    private Integer floorCount;
    private Integer age;

}
