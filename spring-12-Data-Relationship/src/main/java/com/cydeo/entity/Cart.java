package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany //spring create third table(cart_items) and create foreign key
    @JoinTable(name = "cart_item_rel",//change table name
            joinColumns = @JoinColumn(name = "c_id"),//change cart table column name
            inverseJoinColumns = @JoinColumn(name = "i_id"))//change other table column name
    private List<Item> items;
}
