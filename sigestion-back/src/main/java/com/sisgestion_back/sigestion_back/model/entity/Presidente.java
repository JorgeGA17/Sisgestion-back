package com.sisgestion_back.sigestion_back.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "presidente")
@NoArgsConstructor
@AllArgsConstructor

public class Presidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "presidente_pk")
    private Long presidentePk;

    @Column(name = "f_fecha_registro")
    private LocalDateTime fFechaRegistro;

    @ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
    @JoinColumn(name = "periodo_fk")
    private Periodo periodofk;

    @ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
    @JoinColumn(name = "corte_fk")
    private Corte cortefk;

    @ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_fk")
    private Personal personalfk;

}
