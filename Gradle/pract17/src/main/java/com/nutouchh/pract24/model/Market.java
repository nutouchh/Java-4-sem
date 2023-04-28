package com.nutouchh.pract24.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "markets")
@Setter
@Getter
@NoArgsConstructor
public class Market {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="my_entity_seq_gen")
//    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="markets_sequence")
    private Integer id;
    @Column(name = "nname")
    private String name;
    @Column(name = "address")
    private String address;
//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
//            CascadeType.REFRESH, CascadeType.DETACH},
//            fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id")
//    private Product product;

    public Market(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Market{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address +
                '}';
    }
}
