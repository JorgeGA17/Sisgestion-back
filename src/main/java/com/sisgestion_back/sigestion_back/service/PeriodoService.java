package com.sisgestion_back.sigestion_back.service;

import com.sisgestion_back.sigestion_back.mapper.PeriodoMapper;
import com.sisgestion_back.sigestion_back.model.dto.PeriodoRequestDTO;
import com.sisgestion_back.sigestion_back.model.dto.PeriodoResponseDTO;
import com.sisgestion_back.sigestion_back.model.entity.Periodo;
import com.sisgestion_back.sigestion_back.repository.PeriodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor

public class PeriodoService {

    private PeriodoRepository periodoRepository;
    private PeriodoMapper periodoMapper;

    @Transactional(readOnly = true)
    public List<PeriodoResponseDTO> getAllPeriodos() {
        List<Periodo> periodos = periodoRepository.findAll();
        return periodoMapper.convertToDTO(periodos);
    }

    @Transactional(readOnly = true)
    public PeriodoResponseDTO getPeriodoById(Long periodoPk) {
        Periodo periodo = periodoRepository.findById(periodoPk)
                .orElseThrow(()-> new RuntimeException("Periodo no encontrado: "+periodoPk));
        return periodoMapper.convertToDTO(periodo);
    }

    @Transactional
    public PeriodoResponseDTO createPeriodo (PeriodoRequestDTO periodoRequestDTO) {
        Periodo periodo = periodoMapper.convertToEntity(periodoRequestDTO);
        periodo.setFFechaRegistro(LocalDateTime.now());
        periodoRepository.save(periodo);
        return periodoMapper.convertToDTO(periodo);
    }

    @Transactional
    public PeriodoResponseDTO updatePeriodo(Long periodoPk, PeriodoRequestDTO periodoRequestDTO) {
        Periodo periodo = periodoRepository.findById(periodoPk)
                .orElseThrow(()-> new RuntimeException("Periodo no encontrado: "+periodoPk));
        periodo.setXnombre(periodoRequestDTO.getXnombre());
        periodo=periodoRepository.save(periodo);
        return periodoMapper.convertToDTO(periodo);
    }

    @Transactional
    public void deletePeriodo(Long periodoPk) {
        periodoRepository.deleteById(periodoPk);
    }
}
