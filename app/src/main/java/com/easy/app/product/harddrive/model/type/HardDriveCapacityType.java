package com.easy.app.product.harddrive.model.type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "capacity_type_table")
public class HardDriveCapacityType {
    @Id
    private Long id;
    @Column(name = "capacity")
    private Integer capacity;
}
