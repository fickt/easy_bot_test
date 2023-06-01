package com.easy.app.product.monitor.model.entity;

import com.easy.app.manufacturer.Manufacturer;
import com.easy.app.product.monitor.model.type.ScreenSize;
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
@Table(name = "monitor_table")
public class Monitor {
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
    @JoinColumn(name = "fk_screen_size_id", referencedColumnName = "id")
    private ScreenSize screenSize;
}
