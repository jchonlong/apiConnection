package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.model.Predio;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.repository.PredioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/predios")
public class PredioController {

    private final PredioRepository predioRepository;
    private final PersonaRepository personaRepository;

    public PredioController(PredioRepository predioRepository, PersonaRepository personaRepository) {
        this.predioRepository = predioRepository;
        this.personaRepository = personaRepository;
    }

    @GetMapping
    public List<Predio> getAll() {
        return predioRepository.findAll();
    }

    @PostMapping
    public Predio create(@RequestBody Predio predio) {
        Persona duenio = personaRepository.findById(predio.getDuenio().getId())
                .orElseThrow(() -> new RuntimeException("Dueño no encontrado"));
        predio.setDuenio(duenio);
        return predioRepository.save(predio);
    }
}