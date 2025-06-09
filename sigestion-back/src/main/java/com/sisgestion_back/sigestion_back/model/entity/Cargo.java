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
@Table(name = "cargo")
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cargo_pk")
    private Long cargoPk;

    @Column(name = "x_nombre")
    private String xnombre;

    @Column(name = "f_fecha_registro")
    private LocalDateTime fFechaRegistro;

    @OneToMany (mappedBy = "cargofk", cascade = CascadeType.ALL)
    private List<Miembro> miembros= new ArrayList<>();
}
