package com.sisgestion_back.sigestion_back.mapper;

import com.sisgestion_back.sigestion_back.model.dto.*;
import com.sisgestion_back.sigestion_back.model.entity.Especialidad;
import com.sisgestion_back.sigestion_back.model.entity.Proyecto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component

public class ProyectoMapper {

    private final ModelMapper modelMapper;

        public ProyectoResponseDTO convertToDTO(Proyecto proyecto) {
        ProyectoResponseDTO proyectoResponseDTO = modelMapper.map(proyecto, ProyectoResponseDTO.class);

        if (proyecto.getCortefk() != null) {
            proyectoResponseDTO.setCorteId(proyecto.getCortefk().getCortePk());
        }

        if (proyecto.getEstadofk() != null) {
            proyectoResponseDTO.setEstadoId(proyecto.getEstadofk().getEstadoPk());
        }

        List<Long> especialidadIds = Optional.ofNullable(proyecto.getEspecialidades())
                .orElse(Collections.emptyList())
                .stream()
                .map(Especialidad::getEspecialidadPk)
                .collect(Collectors.toList());// Asegúrate de que Curso tiene un método getId()
            proyectoResponseDTO.setEspecialidadIds(especialidadIds);

        List<String>listaEspecialidades = Optional.ofNullable(proyecto.getEspecialidades())
                .orElse(Collections.emptyList())
                .stream()
                .map(Especialidad::getXnombre)
                .collect(Collectors.toList());

        proyectoResponseDTO.setListaEspecialidades(listaEspecialidades);

        return proyectoResponseDTO;
    }

    public Proyecto convertToEntity(ProyectoRequestDTO proyectoRequestDTO) {
        return modelMapper.map(proyectoRequestDTO, Proyecto.class);

    }

    public List<ProyectoResponseDTO> convertToDTO(List<Proyecto> proyectos) {

        return proyectos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

}
