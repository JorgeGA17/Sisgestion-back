package com.sisgestion_back.sigestion_back.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "periodo")
@NoArgsConstructor
@AllArgsConstructor
public class Periodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "periodo_pk")
    private Long periodoPk;

    @Column(name = "x_nombre")
    private String xnombre;

    @Column(name = "f_fecha_registro")
    private LocalDateTime fFechaRegistro;

    @OneToMany (mappedBy = "periodofk", cascade = CascadeType.ALL)
    private List<Comision> comisiones= new ArrayList<>();

    @OneToMany (mappedBy = "periodofk", cascade = CascadeType.ALL)
    private List<Presidente> presidentes= new ArrayList<>();

}

