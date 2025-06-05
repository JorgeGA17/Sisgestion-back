package com.sisgestion_back.sigestion_back.model.dto;

import com.sisgestion_back.sigestion_back.model.entity.Corte;
import com.sisgestion_back.sigestion_back.model.entity.Periodo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ComisionResponseDTO {

    private Long comisionPk;
    private String xdescripcion;
    private LocalDateTime fFechaRegistro;
    private String xresolucion;
    private Corte cortefk;
    private Periodo periodofk;
}
