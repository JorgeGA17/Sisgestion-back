package com.sisgestion_back.sigestion_back.service;

import com.sisgestion_back.sigestion_back.mapper.PresidenteMapper;
import com.sisgestion_back.sigestion_back.model.dto.PresidenteRequestDTO;
import com.sisgestion_back.sigestion_back.model.dto.PresidenteResponseDTO;
import com.sisgestion_back.sigestion_back.model.entity.Presidente;
import com.sisgestion_back.sigestion_back.repository.PresidenteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PresidenteService {

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
        presidenteRepository.save(presidente);
        return presidenteMapper.convertToDTO(presidente);
    }

    @Transactional
    public PresidenteResponseDTO updatePresidente(Long presidentePk, PresidenteRequestDTO presidenteRequestDTO) {
        Presidente presidente = presidenteRepository.findById(presidentePk)
                .orElseThrow(()-> new RuntimeException("Presidente no encontrado"+presidentePk));

        presidente=presidenteRepository.save(presidente);
        return presidenteMapper.convertToDTO(presidente);
    }

    @Transactional
    public void deletePresidente(Long presidentePk) {
        presidenteRepository.deleteById(presidentePk);
    }
}
