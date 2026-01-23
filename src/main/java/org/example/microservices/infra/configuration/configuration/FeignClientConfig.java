package org.example.microservices.infra.configuration.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignClientConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
