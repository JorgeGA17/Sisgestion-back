package com.Sisgestion.Sisgestion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "jerarquia", schema = "schMovimiento")
public class Jerarquia {
    @Id
    @NotNull
    @Column(name = "jerarquia_pk", nullable = false)
    private Integer jerarquiaPk;

    @Size(max = 255)
    @NotNull
    @Column(name = "x_nombre", nullable = false)
    private String xNombre;

    @Column(name = "f_fecha_registro")
    private Instant fFechaRegistro;

    @Column(name = "f_fecha_modificacion")
    private Instant fFechaModificacion;

}