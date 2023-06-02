package com.easy.app.product.harddrive.model.entity;

import com.easy.app.manufacturer.entity.Manufacturer;
import com.easy.app.product.harddrive.model.type.HardDriveCapacityType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "hard_drive_table")
public class HardDrive {
    @Id
    @Column(name = "serial_number",
            unique = true,
            nullable = false
    )
    private String serialNumber;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_manufacturer_id", referencedColumnName = "name")
    private Manufacturer manufacturer;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "quantity", nullable = false)
    private Long quantity;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_capacity_type_id", referencedColumnName = "id")
    private HardDriveCapacityType capacityType;
}
