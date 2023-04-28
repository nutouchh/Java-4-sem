package com.nutouchh.pract16.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Setter
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="my_entity_seq_gen")
//    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="markets_sequence")
    private Integer id;
    @Column(name = "nname")
    private String name;
    @Column(name = "price")
    private String price;
    // Lazy по умолчанию
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH},
            mappedBy = "product",
            fetch = FetchType.LAZY)
    private List<Market> markets;
    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public void addMarketToProduct(Market market) {
        if (markets == null)
            markets = new ArrayList<>();
        markets.add(market);
        market.setProduct(this);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
