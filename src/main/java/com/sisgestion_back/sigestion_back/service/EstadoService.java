package com.sisgestion_back.sigestion_back.service;

import com.sisgestion_back.sigestion_back.mapper.EstadoMapper;
import com.sisgestion_back.sigestion_back.model.dto.EstadoRequestDTO;
import com.sisgestion_back.sigestion_back.model.dto.EstadoResponseDTO;
import com.sisgestion_back.sigestion_back.model.entity.Estado;
import com.sisgestion_back.sigestion_back.repository.EstadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class EstadoService {

    private EstadoRepository estadoRepository;
    private EstadoMapper estadoMapper;

    @Transactional(readOnly = true)
    public List<EstadoResponseDTO> getAllEstados() {
        List<Estado> estados = estadoRepository.findAll();
        return estadoMapper.convertToDTO(estados);
    }

    @Transactional(readOnly = true)
    public EstadoResponseDTO getEstadoById(Long estadoPk) {
        Estado estado = estadoRepository.findById(estadoPk)
                .orElseThrow(()-> new RuntimeException("Estado no encontrado: "+estadoPk));
        return estadoMapper.convertToDTO(estado);
    }

    @Transactional
    public EstadoResponseDTO createEstado (EstadoRequestDTO estadoRequestDTO) {
        Estado estado = estadoMapper.convertToEntity(estadoRequestDTO);
        estado.setFFechaRegistro(LocalDateTime.now());
        estadoRepository.save(estado);
        return estadoMapper.convertToDTO(estado);
    }

    @Transactional
    public  EstadoResponseDTO updateEstado (Long estadoPk, EstadoRequestDTO estadoRequestDTO) {
        Estado estado = estadoRepository.findById(estadoPk)
                .orElseThrow(()-> new RuntimeException("Estado no encontrada: "+estadoPk));
        estado.setXnombre(estadoRequestDTO.getXnombre());
        estado.setXresumen(estadoRequestDTO.getXresumen());
        estado=estadoRepository.save(estado);
        return estadoMapper.convertToDTO(estado);
    }

    @Transactional
    public void deleteEstado(Long estadoPk) {
        estadoRepository.deleteById(estadoPk);}
}
