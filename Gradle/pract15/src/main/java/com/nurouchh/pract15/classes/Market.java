package com.nurouchh.pract15.classes;


//import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "markets")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Market {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nname")
    private String name;
    @Column(name = "address")
    private String address;

    public Market(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
