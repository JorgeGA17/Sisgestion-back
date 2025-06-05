package com.sisgestion_back.sigestion_back.model.dto;

import com.sisgestion_back.sigestion_back.model.entity.Corte;
import com.sisgestion_back.sigestion_back.model.entity.Periodo;
import com.sisgestion_back.sigestion_back.model.entity.Personal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PresidenteResponseDTO {
    private Long presidentePk;
    private LocalDateTime fFechaRegistro;
    private Periodo periodofk;
    private Corte cortefk;
    private Personal personalfk;

}
