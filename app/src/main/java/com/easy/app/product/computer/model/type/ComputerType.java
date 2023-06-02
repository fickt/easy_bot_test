package com.easy.app.product.computer.model.type;

import jakarta.persistence.*;
import lombok.*;

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
