package com.sisgestion_back.sigestion_back.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "jerarquia")
@NoArgsConstructor
@AllArgsConstructor
public class Jerarquia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jerarquia_pk")
    private Long jerarquiaPk;

    @Column(name ="x_nombre")
    private String xnombre;

    @Column(name = "f_fecha_registro")
    private LocalDateTime fFechaRegistro;


}
