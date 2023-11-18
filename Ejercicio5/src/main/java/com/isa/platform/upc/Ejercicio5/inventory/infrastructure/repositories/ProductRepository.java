package com.isa.platform.upc.Ejercicio5.inventory.infrastructure.repositories;

import com.isa.platform.upc.Ejercicio5.inventory.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsBySerialNumber(String serialNumber);
    Optional<Product> findById(Long id);

}
