package com.nutouchh.pract24.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableJpaRepositories(basePackages = "com.nutouchh.pract24.repository")
@EnableAspectJAutoProxy
@EnableAsync
@EnableScheduling
public class SQLConfig {
}
