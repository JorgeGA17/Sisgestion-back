package com.sisgestion_back.sigestion_back.service;

import com.sisgestion_back.sigestion_back.mapper.MiembroMapper;
import com.sisgestion_back.sigestion_back.model.dto.MiembroRequestDTO;
import com.sisgestion_back.sigestion_back.model.dto.MiembroResponseDTO;
import com.sisgestion_back.sigestion_back.model.entity.*;
import com.sisgestion_back.sigestion_back.repository.CargoRepository;
import com.sisgestion_back.sigestion_back.repository.ComisionRepository;
import com.sisgestion_back.sigestion_back.repository.MiembroRepository;
import com.sisgestion_back.sigestion_back.repository.PersonalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MiembroService {

    private final ComisionRepository comisionRepository;
    private final PersonalRepository personalRepository;
    private final CargoRepository cargoRepository;
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
                .orElseThrow(()-> new RuntimeException("Miembro no encontrado: "+miembroPk));
        return miembroMapper.convertToDTO(miembro);
    }

    @Transactional
    public MiembroResponseDTO createMiembro (MiembroRequestDTO miembroRequestDTO) {
        Miembro miembro = miembroMapper.convertToEntity(miembroRequestDTO);
        miembro.setFFechaRegistro(LocalDateTime.now());

        //Obtener y asignar entidades ManyToOne (Corte y Periodo)
        Comision comision = comisionRepository.findById(miembroRequestDTO.getComisionId())
                .orElseThrow(() -> new RuntimeException("Comision no encontrado con ID: " + miembroRequestDTO.getComisionId()));
        Personal personal = personalRepository.findById(miembroRequestDTO.getPersonalId())
                .orElseThrow(() -> new RuntimeException("Personal no encontrado con ID: " + miembroRequestDTO.getPersonalId()));
        Cargo cargo = cargoRepository.findById(miembroRequestDTO.getCargoId())
                .orElseThrow(() -> new RuntimeException("Cargo no encontrado con ID: " + miembroRequestDTO.getCargoId()));

        miembro.setComisionfk(comision);
        miembro.setPersonalfk(personal);
        miembro.setCargofk(cargo);

        miembroRepository.save(miembro);
        return miembroMapper.convertToDTO(miembro);
    }

    @Transactional
    public MiembroResponseDTO updateMiembro(Long miembroPk, MiembroRequestDTO miembroRequestDTO) {
        Miembro miembro = miembroRepository.findById(miembroPk)
                .orElseThrow(()-> new RuntimeException("Miembro no encontrado: "+miembroPk));

        //Obtener y asignar entidades ManyToOne (Corte y Periodo)
        Comision comision = comisionRepository.findById(miembroRequestDTO.getComisionId())
                .orElseThrow(() -> new RuntimeException("Comision no encontrado con ID: " + miembroRequestDTO.getComisionId()));
        Personal personal = personalRepository.findById(miembroRequestDTO.getPersonalId())
                .orElseThrow(() -> new RuntimeException("Personal no encontrado con ID: " + miembroRequestDTO.getPersonalId()));
        Cargo cargo = cargoRepository.findById(miembroRequestDTO.getCargoId())
                .orElseThrow(() -> new RuntimeException("Cargo no encontrado con ID: " + miembroRequestDTO.getCargoId()));

        miembro.setComisionfk(comision);
        miembro.setPersonalfk(personal);
        miembro.setCargofk(cargo);


        miembro=miembroRepository.save(miembro);
        return miembroMapper.convertToDTO(miembro);
    }

    @Transactional
    public void deleteMiembro(Long miembroPk) {
        miembroRepository.deleteById(miembroPk);
    }
}
