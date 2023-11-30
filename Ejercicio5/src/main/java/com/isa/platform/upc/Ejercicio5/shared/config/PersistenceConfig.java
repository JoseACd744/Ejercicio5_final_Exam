package com.isa.platform.upc.Ejercicio5.shared.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * The PersistenceConfig class is used for configuring the persistence layer of the application.
 * This class is annotated with @Configuration, which indicates that this class contains one or more bean methods annotated with @Bean.
 * It is also annotated with @EnableJpaAuditing, which enables JPA Auditing.
 *
 * @version 1.0
 * @author Jose Arenas Conde
 * @since 30/11/2023
 * @see org.springframework.context.annotation.Configuration
 * @see org.springframework.data.jpa.repository.config.EnableJpaAuditing
 */
@Configuration
@EnableJpaAuditing
class PersistenceConfig {

    /**
     * This method is used to create a new AuditorAwareImpl object.
     * It returns an AuditorAware<String> object.
     *
     * @return An AuditorAware<String> object.
     * @see org.springframework.data.domain.AuditorAware
     */
    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }
}
