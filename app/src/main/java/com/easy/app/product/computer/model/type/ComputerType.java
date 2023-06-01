package com.easy.app.product.computer.model.type;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "computer_type_table")
public class ComputerType {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
}
