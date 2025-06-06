package com.sisgestion_back.sigestion_back.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiembroRequestDTO {
//falta registrar para miembro. Ids

    @NotNull(message = "ID de la comision es requerido")
    @Positive(message = "El ID de la comision debe ser un número positivo")
    private Long ComisionId;

    @NotEmpty(message = "La lista de personal es requerida")
    private List<Long> personalId;

    @NotEmpty(message = "La lista de cargo es requerida")
    private List<Long> cargoId;
}
