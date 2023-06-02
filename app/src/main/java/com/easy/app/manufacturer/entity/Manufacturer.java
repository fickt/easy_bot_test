package com.easy.app.manufacturer.entity;

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
    @Column(name = "name", unique = true)
    private String name;
}
