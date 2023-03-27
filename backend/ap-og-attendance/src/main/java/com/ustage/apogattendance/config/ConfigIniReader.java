package com.ustage.apogattendance.config;

import org.ini4j.Wini;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class ConfigIniReader {

    private static final String CONFIG_FILE = "config.ini";
    private static Wini ini;

    public ConfigIniReader() {
        try {
            File configFile = new File(CONFIG_FILE);
            if (!configFile.exists()) {
                throw new RuntimeException("Config file not found: " + CONFIG_FILE);
            }
            ini = new Wini(configFile);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read config file: " + CONFIG_FILE, e);
        }
    }

    public String getDatabaseUrl() {
        return ini.get("database", "url");
    }

    public String getDatabaseUsername() {
        return ini.get("database", "username");
    }

    public String getDatabasePassword() {
        return ini.get("database", "password");
    }
}
