package com.sisgestion_back.sigestion_back.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
