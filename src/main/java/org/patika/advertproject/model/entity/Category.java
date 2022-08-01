package org.patika.advertproject.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Category {

    @Id
    private Long id;
    private String name;

}
