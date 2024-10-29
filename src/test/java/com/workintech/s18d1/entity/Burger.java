package com.workintech.s18d1.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.workintech.s18d1.entity.BreadType;



@Entity
@Table(name = "burgers")
@Data
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private Boolean isVegan;

    @Enumerated(EnumType.STRING)
    private BreadType breadType;  // BreadType burada kullanılıyor
    private String contents;

}
