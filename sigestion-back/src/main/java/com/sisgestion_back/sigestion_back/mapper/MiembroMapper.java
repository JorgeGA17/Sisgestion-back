package com.sisgestion_back.sigestion_back.mapper;

import com.sisgestion_back.sigestion_back.model.dto.MiembroRequestDTO;
import com.sisgestion_back.sigestion_back.model.dto.MiembroResponseDTO;
import com.sisgestion_back.sigestion_back.model.dto.ProyectoResponseDTO;
import com.sisgestion_back.sigestion_back.model.entity.Cargo;
import com.sisgestion_back.sigestion_back.model.entity.Especialidad;
import com.sisgestion_back.sigestion_back.model.entity.Miembro;
import com.sisgestion_back.sigestion_back.model.entity.Personal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class MiembroMapper {

    private final ModelMapper modelMapper;

    private List<String> mapPersonalToFullNames(List<Personal> personal) {
        return Optional.ofNullable(personal)
                .orElse(Collections.emptyList())
                .stream()
                .map(Personal::getXnombreCompleto)
                .collect(Collectors.toList());
    }

    private List<String> mapCargoToFullNames(List<Cargo> cargos) {
        return Optional.ofNullable(cargos)
                .orElse(Collections.emptyList())
                .stream()
                .map(Cargo::getXnombre)
                .collect(Collectors.toList());
    }

    public Miembro convertToEntity(MiembroRequestDTO miembroRequestDTO) {
        return modelMapper.map(miembroRequestDTO, Miembro.class);
    }

    public MiembroResponseDTO convertToDTO(Miembro miembro) {
        MiembroResponseDTO miembroResponseDTO = modelMapper.map(miembro, MiembroResponseDTO.class);

        // Mapeo para relaciones ManyToOne (Comision)
        if (miembro.getComisionfk() != null) {
            miembroResponseDTO.setComisionId(miembro.getComisionfk().getComisionPk());
            miembroResponseDTO.setComisionNombreCorte(miembro.getComisionfk().getCortefk().getXnombreCorto());
        } else {
            miembroResponseDTO.setComisionId(null);
            miembroResponseDTO.setComisionNombreCorte(null);
        }


      /*  miembroResponseDTO.setPersonalIds(
                Optional.ofNullable(miembro.getPersonalfk())
                        .orElse((Personal) Collections.emptyList())
                        .map(Personal::getPersonalPk)
                        .collect(Collectors.toList())
        );

        es por porque es manytone y lo vas a necesitar es many to many chequear
*/

        return miembroResponseDTO;

    }

    public List<MiembroResponseDTO> convertToDTO(List<Miembro> miembros) {
        return miembros.stream()
                .map(this::convertToDTO)
                .toList();
    }
}
