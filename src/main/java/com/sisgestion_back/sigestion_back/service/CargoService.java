package com.sisgestion_back.sigestion_back.service;

import com.sisgestion_back.sigestion_back.mapper.CargoMapper;
import com.sisgestion_back.sigestion_back.model.dto.CargoRequestDTO;
import com.sisgestion_back.sigestion_back.model.dto.CargoResponseDTO;
import com.sisgestion_back.sigestion_back.model.entity.Cargo;
import com.sisgestion_back.sigestion_back.repository.CargoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CargoService {
    private CargoRepository cargoRepository;
    private CargoMapper cargoMapper;

    @Transactional(readOnly = true)
    public List<CargoResponseDTO> getAllCargos() {
        List<Cargo> cargos = cargoRepository.findAll();
        return cargoMapper.convertToDTO(cargos);
    }

    @Transactional(readOnly = true)
    public CargoResponseDTO getCargoById(Long cargoPk) {
        Cargo cargo = cargoRepository.findById(cargoPk)
                .orElseThrow(()-> new RuntimeException("Cargo no encontrado: "+cargoPk));
        return cargoMapper.convertToDTO(cargo);
    }

    @Transactional
    public CargoResponseDTO createCargo (CargoRequestDTO cargoRequestDTO) {
        Cargo cargo = cargoMapper.convertToEntity(cargoRequestDTO);
        cargo.setFFechaRegistro(LocalDateTime.now());
        cargoRepository.save(cargo);
        return cargoMapper.convertToDTO(cargo);
    }

    @Transactional
    public CargoResponseDTO updateCargo(Long cargoPk, CargoRequestDTO cargoRequestDTO) {
        Cargo cargo = cargoRepository.findById(cargoPk)
                .orElseThrow(()-> new RuntimeException("Cargo no encontrado: "+cargoPk));
        cargo.setXnombre(cargoRequestDTO.getXnombre());
             cargo=cargoRepository.save(cargo);
        return cargoMapper.convertToDTO(cargo);
    }

    @Transactional
    public void deleteCargo(Long cargoPk) {
        cargoRepository.deleteById(cargoPk);
    }
}
