package ru.arthur.hackathon.medicine.config;

import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
