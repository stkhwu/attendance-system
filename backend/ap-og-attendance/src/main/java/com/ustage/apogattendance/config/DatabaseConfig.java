package com.ustage.apogattendance.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Value("#{configIniReader.databaseUrl}")
    private String databaseUrl;

    @Value("#{configIniReader.databaseUsername}")
    private String databaseUsername;

    @Value("#{configIniReader.databasePassword}")
    private String databasePassword;

// Other configuration methods if needed
}
