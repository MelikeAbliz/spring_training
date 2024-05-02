package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

    public Item(String name, String code) {
        this.name = name;
        this.code = code;
    }

    @ManyToMany(mappedBy = "items")//spring create third table for us(items_carts) and create foreign key
   //there have two foreign key , if we want to one foreign key use mappedBy
    private List<Cart> carts;
}