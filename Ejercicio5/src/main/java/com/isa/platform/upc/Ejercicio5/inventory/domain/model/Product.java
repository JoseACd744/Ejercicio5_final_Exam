package com.isa.platform.upc.Ejercicio5.inventory.domain.model;


import com.isa.platform.upc.Ejercicio5.inventory.domain.enums.MonitoringLevel;
import com.isa.platform.upc.Ejercicio5.shared.Model.Auditable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "serial_number", nullable = false)
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "monitoring_level", nullable = false)
    private MonitoringLevel monitoringLevel;



}
