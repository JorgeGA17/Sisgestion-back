package com.sisgestion_back.sigestion_back.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "corte")
@NoArgsConstructor
@AllArgsConstructor

public class Corte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "corte_pk")
    private Long cortePk;

    @Column(name = "x_nombre")
    private String xnombre;

    @Column(name = "x_nombre_corto")
    private String xnombreCorto;

    @Column(name = "f_fecha_registro")
    private LocalDateTime fFechaRegistro;

  @OneToMany (mappedBy = "cortefk", cascade = CascadeType.DETACH)
  private List<Proyecto> proyectos;

  @OneToMany (mappedBy = "cortefk", cascade = CascadeType.DETACH)
  private List<Comision> comisiones;

  @OneToMany (mappedBy = "cortefk", cascade = CascadeType.DETACH)
  private List<Presidente> presidentes;
}