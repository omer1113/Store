package com.store.Beans;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    @Setter(AccessLevel.PRIVATE)
    private int id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String LastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Singular
    private List<Product> products;
}
