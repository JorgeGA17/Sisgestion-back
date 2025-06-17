package com.sisgestion_back.sigestion_back.service;

import com.sisgestion_back.sigestion_back.mapper.PersonalMapper;
import com.sisgestion_back.sigestion_back.model.dto.PersonalRequestDTO;
import com.sisgestion_back.sigestion_back.model.dto.PersonalResponseDTO;
import com.sisgestion_back.sigestion_back.model.entity.Personal;
import com.sisgestion_back.sigestion_back.repository.PersonalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PersonalService {

    private PersonalRepository personalRepository;
    private PersonalMapper personalMapper;

    @Transactional(readOnly = true)
    public List<PersonalResponseDTO> getAllPersonas() {
        List<Personal> personas = personalRepository.findAll();
        return personalMapper.convertToDTO(personas);
    }

    @Transactional(readOnly = true)
    public PersonalResponseDTO getPersonalById(Long personalPk) {
        Personal personal = personalRepository.findById(personalPk)
                .orElseThrow(() -> new RuntimeException("Personal no encontrado: " + personalPk));
        return personalMapper.convertToDTO(personal);
    }

    @Transactional
    public PersonalResponseDTO createPersonal(PersonalRequestDTO personalRequestDTO) {
        Personal personal = personalMapper.convertToEntity(personalRequestDTO);
        personal.setXnombreCompleto(personal.getXnombre() + " " + personal.getXapellido());
        personal.setFFechaRegistro(LocalDateTime.now());
        personalRepository.save(personal);
        return personalMapper.convertToDTO(personal);
    }

    @Transactional
    public PersonalResponseDTO updatePersonal(Long personalPk, PersonalRequestDTO personalRequestDTO) {
        Personal personal = personalRepository.findById(personalPk)
                .orElseThrow(() -> new RuntimeException("Personal no encontrado: " + personalPk));

        personal.setXnombre(personalRequestDTO.getXnombre());
        personal.setXapellido(personalRequestDTO.getXapellido());
        personal.setXnombreCompleto(personal.getXnombre() + " " + personal.getXapellido());
       // personal.setXcorreoInstitucional(personalRequestDTO.getXcorreoInstitucional());
        personal.setNnumeroDocumento(personalRequestDTO.getNnumeroDocumento());
        personal.setXtipoDocumento(personalRequestDTO.getXtipoDocumento());
        personal = personalRepository.save(personal);
        return personalMapper.convertToDTO(personal);
    }

    @Transactional
    public void deletePersonal(Long personalPk) {
        personalRepository.deleteById(personalPk);
    }
}