package com.itransition.coreservice.core.probability;

import java.util.Random;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProbabilityConfiguration {

    @Bean
    public Random random() {
        return new Random();
    }
}
