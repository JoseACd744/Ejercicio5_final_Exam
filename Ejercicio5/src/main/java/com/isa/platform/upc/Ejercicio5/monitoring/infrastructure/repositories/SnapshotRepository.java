package com.isa.platform.upc.Ejercicio5.monitoring.infrastructure.repositories;


import com.isa.platform.upc.Ejercicio5.inventory.domain.model.Product;
import com.isa.platform.upc.Ejercicio5.monitoring.domain.model.Snapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SnapshotRepository extends JpaRepository<Snapshot,Long> {

    List<Snapshot> findByProductId(Long productId);

}
