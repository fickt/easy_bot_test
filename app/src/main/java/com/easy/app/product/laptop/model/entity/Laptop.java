package com.easy.app.product.laptop.model.entity;

import com.easy.app.manufacturer.Manufacturer;
import com.easy.app.product.laptop.model.type.InchType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "laptop_table")
public class Laptop {
    @Id
    @Column(name = "serial_number",
            unique = true,
            nullable = false
    )
    private String serialNumber; // не уточнён формат серийного номера, будет String на всякий случай
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_manufacturer_id", referencedColumnName = "id")
    private Manufacturer manufacturer;
    @Column(name = "price", nullable = false)
    private BigDecimal price; //для пущей точности BigDecimal
    @Column(name = "quantity", nullable = false)
    private Long quantity;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_inch_type_id", referencedColumnName = "id")
    private InchType inchType;
}
