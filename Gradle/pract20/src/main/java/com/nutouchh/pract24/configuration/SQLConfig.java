package com.nutouchh.pract24.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.nutouchh.pract24.repository")
public class SQLConfig {
}
