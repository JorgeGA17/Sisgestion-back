package com.sisgestion_back.sigestion_back.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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