package com.isa.platform.upc.Ejercicio5.shared.config;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Represents the configuration of the ModelMapper.
 * This class is annotated with @Configuration, which indicates that this class contains one or more bean methods annotated with @Bean.
 */
@Configuration
public class ModelMapperConfig {
    /**
     * Method that creates a new ModelMapper object.
     * @return ModelMapper
     */
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

}
