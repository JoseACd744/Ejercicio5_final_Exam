    package com.isa.platform.upc.Ejercicio5.monitoring.domain.model;

    import com.fasterxml.jackson.annotation.JsonProperty;
    import com.isa.platform.upc.Ejercicio5.inventory.domain.model.Product;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Entity
    @Table(name = "snapshots")
    public class Snapshot {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Long id;

        @Column(name = "snapshot_id", nullable = false)
        private String snapshotId;

        @Column(name = "product_serial_number", nullable = false)
        private String productSerialNumber;

        @Column(name = "temperature", nullable = false)
        private Double temperature;

        @Column(name = "energy", nullable = false)
        private Double energy;

        @Column(name = "leakage", nullable = false)
        private Integer leakage;

        @ManyToOne
        @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "FK_product_snapshot"))
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private Product product;
    }