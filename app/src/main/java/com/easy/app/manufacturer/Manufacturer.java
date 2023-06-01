package com.easy.app.manufacturer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "manufacturer_table")
public class Manufacturer {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
}
