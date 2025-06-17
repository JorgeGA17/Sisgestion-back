package com.sisgestion_back.sigestion_back.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "eje")
@NoArgsConstructor
@AllArgsConstructor
public class Eje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eje_pk")
    private Long ejePk;

    @Column(name = "x_nombre")
    private String xnombre;

    @Column(name = "x_resumen")
    private String xresumen;

    @Column(name = "f_fecha_registro")
    private LocalDateTime fFechaRegistro;


}