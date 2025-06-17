package com.sisgestion_back.sigestion_back.controller;

import com.sisgestion_back.sigestion_back.model.dto.PresidenteRequestDTO;
import com.sisgestion_back.sigestion_back.model.dto.PresidenteResponseDTO;
import com.sisgestion_back.sigestion_back.service.PresidenteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Presidentes")
@AllArgsConstructor
@CrossOrigin(originPatterns = "http://localhost:4200/")
public class PresidenteController {
    private final PresidenteService presidenteService;

    @GetMapping
    public ResponseEntity<List<PresidenteResponseDTO>> getAllPresidentes() {
        List<PresidenteResponseDTO> presidentes = presidenteService.getAllPresidentes();
        return new ResponseEntity<>(presidentes, HttpStatus.OK);
    }

    @GetMapping("/{presidentePk}")
    public ResponseEntity<PresidenteResponseDTO> getPresidenteById(@PathVariable Long presidentePk) {
        PresidenteResponseDTO presidente = presidenteService.getPresidenteById(presidentePk);
        return new ResponseEntity<>(presidente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PresidenteResponseDTO> createPresidente(@Validated @RequestBody PresidenteRequestDTO presidenteDTO) {
        PresidenteResponseDTO createdPresidente = presidenteService.createPresidente(presidenteDTO);
        return new ResponseEntity<>(createdPresidente, HttpStatus.CREATED);
    }

    @PutMapping("/{presidentePk}")
    public ResponseEntity<PresidenteResponseDTO> updatePresidente(@PathVariable Long presidentePk, @Valid @RequestBody PresidenteRequestDTO presidenteDTO) {
        PresidenteResponseDTO updatedPresidente = presidenteService.updatePresidente(presidentePk, presidenteDTO);
        return new ResponseEntity<>(updatedPresidente, HttpStatus.OK);
    }

    @DeleteMapping("/{presidentePk}")
    public ResponseEntity<Void> deletePresidente(@PathVariable Long presidentePk) {
        presidenteService.deletePresidente(presidentePk);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
