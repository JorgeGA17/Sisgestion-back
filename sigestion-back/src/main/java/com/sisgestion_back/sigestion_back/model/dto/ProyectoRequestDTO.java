package com.sisgestion_back.sigestion_back.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProyectoRequestDTO {

    @NotBlank(message = "Nombre proyecto es requerido")
    private String xnombreproyecto;

    private String xslug;

    @NotBlank(message = "Problematica es requerido")
    private String xproblematica;

    @NotBlank(message = "Resumen es requerido")
    private String xresumen;

    @NotBlank(message = "Objetivo General es requerido")
    private String xobjetivogeneral;

    private Integer xinnovacion;

    private Integer ximpacto;

    private Integer xsostenibilidad;

    private Integer xreplicabilidad;

    private String npublicacion;

    @NotNull(message = "ID de la corte es requerido")
    private Integer corteId;
    @NotNull(message = "ID del estado es requerido")
    private Integer estadoId;

    @NotEmpty(message = "La lista de especialidades es requerida")
    private List<Long> especialidadIds;
    @NotEmpty(message = "La lista de jerarquias es requerida")
    private List<Long> jerarquiaIds;
    @NotEmpty(message = "La lista de ejes es requerida")
    private List<Long> ejeIds;
   // @NotEmpty(message = "La lista de etiquetas es requerida")
    //private List<Long> etiquetaIds;
    @NotEmpty(message = "La lista de personas es requerida")
    private List<Long> personalIds;
}
