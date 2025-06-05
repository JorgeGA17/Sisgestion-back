package com.sisgestion_back.sigestion_back.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PresidenteRequestDTO {
    //falta llenar datos para registro de presidente manualmente
    private List<String> personalId;
    private List<String> corteId;
    private List<String> periodoId;
}
