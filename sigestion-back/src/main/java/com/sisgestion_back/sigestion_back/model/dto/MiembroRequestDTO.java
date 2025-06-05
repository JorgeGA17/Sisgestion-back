package com.sisgestion_back.sigestion_back.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiembroRequestDTO {
//falta registrar para miembro. Ids

    private List<String> comisionId;
    private List<String> personalId;
    private List<String> cargoId;
}
