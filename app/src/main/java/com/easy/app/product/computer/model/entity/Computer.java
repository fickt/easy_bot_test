package com.easy.app.product.computer.model.entity;

import com.easy.app.manufacturer.entity.Manufacturer;
import com.easy.app.product.computer.model.type.ComputerType;
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
@Table(name = "computer_table")
public class Computer {
    @Id
    @Column(name = "serial_number",
            unique = true,
            nullable = false
    )
    private String serialNumber; // не уточнён формат серийного номера, будет String на всякий случай
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_manufacturer_id", referencedColumnName = "name")
    private Manufacturer manufacturer;
    @Column(name = "price", nullable = false)
    private BigDecimal price; //для пущей точности BigDecimal
    @Column(name = "quantity", nullable = false)
    private Long quantity;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_computer_type_id", referencedColumnName = "id")
    private ComputerType computerType;
}
