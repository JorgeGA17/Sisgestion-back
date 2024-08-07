package com.sisgestion_back.sigestion_back.model.dto;

import com.sisgestion_back.sigestion_back.model.entity.Proyecto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CorteResponseDTO {

    private Long cortePk;

    private BigDecimal cCodigo;

    private String xNombre;

    private String xSlug;

    private String xNombreCorto;

    private String nEstado;

    private Instant fFechaRegistro;

    private Instant fFechaModificacion;
}
