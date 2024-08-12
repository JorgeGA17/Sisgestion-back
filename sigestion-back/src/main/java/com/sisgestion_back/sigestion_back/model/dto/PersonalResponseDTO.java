package com.sisgestion_back.sigestion_back.model.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalResponseDTO {

    private Long personalPk;
    private String xtipoDocumento;
    private String nnumeroDocumento;
    private String xnombreCompleto;
    private String xnombre;
    private String xapellido;
    private String xocupacion;
    private String xcorreoInstitucional;

}
