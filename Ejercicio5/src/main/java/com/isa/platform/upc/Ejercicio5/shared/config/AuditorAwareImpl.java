package com.isa.platform.upc.Ejercicio5.shared.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("COD_USUARIO");
    }
}
