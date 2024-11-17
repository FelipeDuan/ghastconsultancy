package com.ghastconsultancy.ghastconsultancy.core.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Ghast Consultancy API")
                        .version("v1")
                        .description("API Sistema de Gestão de Consultorias (Ghast Consultancy)"));
    }
}
