package com.store.Beans;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    @Setter(AccessLevel.PRIVATE)
    private int id;

    private int companyID;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private double price;


}
