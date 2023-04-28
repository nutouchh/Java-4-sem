package com.nutouchh.pract13;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
    @Value("${user.name}")
    private String name;

    @Value("${user.lastname}")
    private String lastname;

    @Value("${user.group}")
    private String group;

    @PostConstruct
    public void postConstruct() {
        System.out.println(name + " " + lastname + " " + group);
    }
}
