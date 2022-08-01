package org.patika.advertproject.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Getter
@Setter
public class Address {

    @Id
    private Long id;
    private String city;
    private String street;
    private String houseNumber;
    private String zipCode;
    private String country;

}
