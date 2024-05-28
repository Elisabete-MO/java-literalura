package edu.LiterAlura.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EnvCheck {
    @Value("${DB_HOST}")
    private String dbHost;

    @Value("${POSTGRESQL_PORT}")
    private String dbPort;

    @Value("${POSTGRESQL_DB_NAME}")
    private String dbName;

    @Value("${POSTGRESQL_USER}")
    private String dbUser;

    @Value("${POSTGRESQL_PASSWORD}")
    private String dbPass;

    @PostConstruct
    public void init() {
        System.out.println("DB_HOST: " + dbHost);
        System.out.println("DB_PORT: " + dbPort);
        System.out.println("DB_NAME: " + dbName);
        System.out.println("DB_USER: " + dbUser);
        System.out.println("DB_PASS: " + dbPass);
    }

}
