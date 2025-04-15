package com.application.x_cinema.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Movie Booking API")
                        .version("1.0.0")
                        .description("API docs for the movie ticket booking system")
                        .contact(new Contact()
                                .name("Nguyen Minh Nam")
                                .email("mhnamm10@gmai.com")
                        )
                );
    }
}
