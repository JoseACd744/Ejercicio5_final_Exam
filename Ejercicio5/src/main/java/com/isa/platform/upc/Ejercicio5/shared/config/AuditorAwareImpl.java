
package com.isa.platform.upc.Ejercicio5.shared.config;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
/**
 * The AuditorAwareImpl class is used for setting the current auditor.
 * It implements the AuditorAware interface.
 *
 * @version 1.0
 * @author Jose Arenas Conde
 * @since 30/11/2023
 * @see org.springframework.data.domain.AuditorAware
 */
public class AuditorAwareImpl implements AuditorAware<String> {

    /**
     * This method is used to get the current auditor.
     * It returns an Optional containing the ID of the current auditor.
     *
     * @return An Optional containing the ID of the current auditor.
     * @see java.util.Optional
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("COD_USUARIO");
    }
}