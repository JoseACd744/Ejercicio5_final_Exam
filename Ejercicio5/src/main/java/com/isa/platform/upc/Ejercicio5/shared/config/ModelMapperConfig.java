
package com.isa.platform.upc.Ejercicio5.shared.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * The ModelMapperConfig class is used for configuring the ModelMapper.
 * This class is annotated with @Configuration, which indicates that this class contains one or more bean methods annotated with @Bean.
 *
 * @version 1.0
 * @author Jose Arenas Conde
 * @since 30/11/2023
 * @see org.springframework.context.annotation.Configuration
 */
@Configuration
public class ModelMapperConfig {

    /**
     * This method is used to create a new ModelMapper object.
     * It sets the matching strategy of the ModelMapper configuration to STRICT.
     *
     * @return A ModelMapper object with STRICT matching strategy.
     * @see org.modelmapper.ModelMapper
     * @see org.modelmapper.convention.MatchingStrategies
     */
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}