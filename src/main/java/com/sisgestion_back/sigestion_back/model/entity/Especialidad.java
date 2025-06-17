package com.sisgestion_back.sigestion_back.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Data
    @Entity
    @Table(name = "especialidad")
    @NoArgsConstructor
    @AllArgsConstructor

    public class Especialidad {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "especialidad_pk")
        private Long especialidadPk;

        @Column(name = "x_nombre")
        private String xnombre;

        @Column(name = "f_fecha_registro")
        private LocalDateTime fFechaRegistro;

    }
