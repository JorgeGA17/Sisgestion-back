package com.sisgestion_back.sigestion_back.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "personal")
@NoArgsConstructor
@AllArgsConstructor
public class Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personal_pk")
    private Long personalPk;

    @Column(name = "x_tipo_documento")
    private String xtipoDocumento;

    @Column(name = "n_numero_documento")
    private String nnumeroDocumento;

    @Column(name = "x_nombre_completo")
    private String xnombreCompleto;

    @Column(name = "x_nombre")
    private String xnombre;

    @Column(name = "x_apellido")
    private String xapellido;

    @Column(name = "x_ocupacion")
    private String xocupacion;

    @Column(name = "x_correo_institucional")
    private String xcorreoInstitucional;

    @Column(name = "f_fecha_registro")
    private LocalDateTime fFechaRegistro;


    @OneToMany (mappedBy = "personalfk", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Presidente> presidentes;

    @OneToMany (mappedBy = "personalfk", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Miembro> miembros;

}
