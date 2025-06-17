package com.sisgestion_back.sigestion_back.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "etiqueta")
@NoArgsConstructor
@AllArgsConstructor

public class Etiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "etiqueta_pk")
    private Long etiquetaPk;

    @Column(name ="x_nombre")
    private String xnombre;

    @Column(name ="x_campo")
    private String xcampo;

    @Column(name = "f_fecha_registro")
    private LocalDateTime fFechaRegistro;

}
