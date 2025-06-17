package com.sisgestion_back.sigestion_back.service;

import com.sisgestion_back.sigestion_back.mapper.PresidenteMapper;
import com.sisgestion_back.sigestion_back.model.dto.PresidenteRequestDTO;
import com.sisgestion_back.sigestion_back.model.dto.PresidenteResponseDTO;
import com.sisgestion_back.sigestion_back.model.entity.*;
import com.sisgestion_back.sigestion_back.repository.CorteRepository;
import com.sisgestion_back.sigestion_back.repository.PeriodoRepository;
import com.sisgestion_back.sigestion_back.repository.PersonalRepository;
import com.sisgestion_back.sigestion_back.repository.PresidenteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PresidenteService {

    private final PeriodoRepository periodoRepository;
    private final PersonalRepository personalRepository;
    private final CorteRepository corteRepository;
    private PresidenteRepository presidenteRepository;
    private PresidenteMapper presidenteMapper;

    @Transactional(readOnly = true)
    public List<PresidenteResponseDTO> getAllPresidentes() {
        List<Presidente> presidentes = presidenteRepository.findAll();
        return presidenteMapper.convertToDTO(presidentes);
    }

    @Transactional(readOnly = true)
    public PresidenteResponseDTO getPresidenteById(Long presidentePk) {
        Presidente presidente = presidenteRepository.findById(presidentePk)
                .orElseThrow(()-> new RuntimeException("Presidente no encontrado"+presidentePk));
        return presidenteMapper.convertToDTO(presidente);
    }

    @Transactional
    public PresidenteResponseDTO createPresidente(PresidenteRequestDTO presidenteRequestDTO) {
        Presidente presidente = presidenteMapper.convertToEntity(presidenteRequestDTO);
        presidente.setFFechaRegistro(LocalDateTime.now());

        //Obtener y asignar entidades ManyToOne (Corte y Periodo)
        Periodo periodo = periodoRepository.findById(presidenteRequestDTO.getPeriodoId())
                .orElseThrow(() -> new RuntimeException("Periodo no encontrado con ID: " + presidenteRequestDTO.getPeriodoId()));
        Personal personal = personalRepository.findById(presidenteRequestDTO.getPersonalId())
                .orElseThrow(() -> new RuntimeException("Personal no encontrado con ID: " + presidenteRequestDTO.getPersonalId()));
        Corte corte = corteRepository.findById(presidenteRequestDTO.getCorteId())
                .orElseThrow(() -> new RuntimeException("Corte no encontrado con ID: " + presidenteRequestDTO.getCorteId()));

        presidente.setPeriodofk(periodo);
        presidente.setPersonalfk(personal);
        presidente.setCortefk(corte);

        presidenteRepository.save(presidente);
        return presidenteMapper.convertToDTO(presidente);
    }

    @Transactional
    public PresidenteResponseDTO updatePresidente(Long presidentePk, PresidenteRequestDTO presidenteRequestDTO) {
        Presidente presidente = presidenteRepository.findById(presidentePk)
                .orElseThrow(()-> new RuntimeException("Presidente no encontrado: "+presidentePk));

        //Obtener y asignar entidades ManyToOne (Corte y Periodo)
        Periodo periodo = periodoRepository.findById(presidenteRequestDTO.getPeriodoId())
                .orElseThrow(() -> new RuntimeException("Periodo no encontrado con ID: " + presidenteRequestDTO.getPeriodoId()));
        Personal personal = personalRepository.findById(presidenteRequestDTO.getPersonalId())
                .orElseThrow(() -> new RuntimeException("Personal no encontrado con ID: " + presidenteRequestDTO.getPersonalId()));
        Corte corte = corteRepository.findById(presidenteRequestDTO.getCorteId())
                .orElseThrow(() -> new RuntimeException("Corte no encontrado con ID: " + presidenteRequestDTO.getCorteId()));

        presidente.setPeriodofk(periodo);
        presidente.setPersonalfk(personal);
        presidente.setCortefk(corte);

        presidente=presidenteRepository.save(presidente);
        return presidenteMapper.convertToDTO(presidente);
    }

    @Transactional
    public void deletePresidente(Long presidentePk) {
        presidenteRepository.deleteById(presidentePk);
    }
}
