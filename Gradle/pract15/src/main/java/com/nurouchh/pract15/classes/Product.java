package com.nurouchh.pract15.classes;

//import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nname")
    private String name;
    @Column(name = "price")
    private String price;

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }
}
