package com.ustage.apogattendance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private final Environment env;
    private final ConfigIniReader configIniReader;

    @Autowired
    public DataSourceConfig(Environment env, ConfigIniReader configIniReader) {
        this.env = env;
        this.configIniReader = configIniReader;
    }

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(configIniReader.getDatabaseUrl());
        dataSourceBuilder.username(configIniReader.getDatabaseUsername());
        dataSourceBuilder.password(configIniReader.getDatabasePassword());
        dataSourceBuilder.driverClassName(env.getProperty("spring.datasource.driver-class-name"));
        return dataSourceBuilder.build();
    }
}

