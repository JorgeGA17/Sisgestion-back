package com.sisgestion_back.sigestion_back.model.dto;

import com.sisgestion_back.sigestion_back.model.entity.Cargo;
import com.sisgestion_back.sigestion_back.model.entity.Comision;
import com.sisgestion_back.sigestion_back.model.entity.Personal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiembroResponseDTO {
    private Long miembroPk;
    private LocalDateTime fFechaRegistro;
    private Comision comisionfk;
    private Personal personalfk;
    private Cargo cargofk;


}
