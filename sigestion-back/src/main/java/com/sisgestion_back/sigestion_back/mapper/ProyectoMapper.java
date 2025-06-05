package com.sisgestion_back.sigestion_back.mapper;

import com.sisgestion_back.sigestion_back.model.dto.*;
import com.sisgestion_back.sigestion_back.model.entity.Especialidad;
import com.sisgestion_back.sigestion_back.model.entity.Proyecto;
import com.sisgestion_back.sigestion_back.repository.CorteRepository;
import com.sisgestion_back.sigestion_back.repository.EstadoRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component

public class ProyectoMapper {

    private final ModelMapper modelMapper;

        public ProyectoResponseDTO convertToDTO(Proyecto proyecto) {
        return modelMapper.map(proyecto, ProyectoResponseDTO.class);
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
