package com.sisgestion_back.sigestion_back.model.dto;

import com.sisgestion_back.sigestion_back.Enum.ERole;
import lombok.Data;

@Data
public class UserProfileDTO {

    private Long userPk;

    private String xnombre;
    private String xapellido;

    private String xcorreoInstitucional;
    private ERole role;
}
