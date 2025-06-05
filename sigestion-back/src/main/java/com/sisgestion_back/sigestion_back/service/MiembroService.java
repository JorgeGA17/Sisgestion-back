package com.sisgestion_back.sigestion_back.service;

import com.sisgestion_back.sigestion_back.mapper.MiembroMapper;
import com.sisgestion_back.sigestion_back.model.dto.MiembroRequestDTO;
import com.sisgestion_back.sigestion_back.model.dto.MiembroResponseDTO;
import com.sisgestion_back.sigestion_back.model.entity.Miembro;
import com.sisgestion_back.sigestion_back.repository.MiembroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class MiembroService {

    private MiembroRepository miembroRepository;
    private MiembroMapper miembroMapper;

    @Transactional(readOnly = true)
    public List<MiembroResponseDTO> getAllMiembros() {
        List<Miembro> miembros = miembroRepository.findAll();
        return miembroMapper.convertToDTO(miembros);
    }

    @Transactional(readOnly = true)
    public MiembroResponseDTO getMiembroById(Long miembroPk) {
        Miembro miembro = miembroRepository.findById(miembroPk)
                .orElseThrow(()-> new RuntimeException("Miembro no encontrado"+miembroPk));
        return miembroMapper.convertToDTO(miembro);
    }

    @Transactional
    public MiembroResponseDTO createMiembro (MiembroRequestDTO miembroRequestDTO) {
        Miembro miembro = miembroMapper.convertToEntity(miembroRequestDTO);
        miembroRepository.save(miembro);
        return miembroMapper.convertToDTO(miembro);
    }

    @Transactional
    public MiembroResponseDTO updateMiembro(Long miembroPk, MiembroRequestDTO miembroRequestDTO) {
        Miembro miembro = miembroRepository.findById(miembroPk)
                .orElseThrow(()-> new RuntimeException("Miembro no encontrado"+miembroPk));
        miembro=miembroRepository.save(miembro);
        return miembroMapper.convertToDTO(miembro);
    }

    @Transactional
    public void deleteMiembro(Long miembroPk) {
        miembroRepository.deleteById(miembroPk);
    }
}
