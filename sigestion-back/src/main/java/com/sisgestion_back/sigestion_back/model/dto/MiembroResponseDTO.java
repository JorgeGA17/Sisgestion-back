package com.sisgestion_back.sigestion_back.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiembroResponseDTO {
    private Long miembroPk;
    private LocalDateTime fFechaRegistro;

    // Campos para relaciones ManyToOne
    private Long comisionId;
    private String comisionNombreCorte;

    // IDs de las colecciones ManyToMany
    private List<Long> personalIds;
    private List<Long> cargoIds;

    // Nombres/Descripciones de las colecciones ManyToMany
    private List<String> listaNombresPersonas;
    private List<String> listaNombresCargos;


}
