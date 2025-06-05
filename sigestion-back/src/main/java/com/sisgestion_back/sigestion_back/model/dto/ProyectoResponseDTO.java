package com.sisgestion_back.sigestion_back.model.dto;


import com.sisgestion_back.sigestion_back.model.entity.Corte;
import com.sisgestion_back.sigestion_back.model.entity.Estado;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProyectoResponseDTO {

    private Long proyectopk;
    private String xnombreproyecto;
    private String xslug;
    private String xproblematica;
    private String xresumen;
    private String xobjetivogeneral;
    private Integer xinnovacion;
    private Integer ximpacto;
    private Integer xsostenibilidad;
    private Integer xreplicabilidad;
    private String npublicacion;
    private Integer npeso;
    private LocalDateTime ffecha;

    private Long corteId;
    private Long estadoId;

    private List<String> listaEspecialidades;
    private List<String>  listaJerarquias;
    private List<String>  listaEjes;
    private List<String>  listaEtiquetas;
    private List<String>  listaPersonal;
}
