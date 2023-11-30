package com.isa.platform.upc.Ejercicio5.shared.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * The SwaggerConfig class is used for configuring Swagger for API documentation.
 * This class is annotated with @Configuration, which indicates that this class contains one or more bean methods annotated with @Bean.
 *
 * @version 1.0
 * @author Jose Arenas Conde
 * @since 30/11/2023
 * @see org.springframework.context.annotation.Configuration
 */
@Configuration
public class SwaggerConfig {

    /**
     * This method is used to create a new OpenAPI object.
     * It sets the information about the API, adds a security item for JWT authentication, and adds a security scheme for JWT.
     *
     * @return An OpenAPI object with the API information, security item, and security scheme set.
     * @see io.swagger.v3.oas.models.OpenAPI
     * @see io.swagger.v3.oas.models.Components
     * @see io.swagger.v3.oas.models.info.Info
     * @see io.swagger.v3.oas.models.security.SecurityRequirement
     * @see io.swagger.v3.oas.models.security.SecurityScheme
     */
    @Bean
    public OpenAPI openApiConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("ISA API")
                        .description("API for inventory management")
                        .version("1.0.0")
                )
                .addSecurityItem(new SecurityRequirement()
                        .addList("JwtScheme")
                )
                .components(new Components()
                        //JWT
                        .addSecuritySchemes("JwtScheme",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .description("Authorize with a JWT token")
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )
                );
    }
}