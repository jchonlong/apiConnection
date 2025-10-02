package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    private final PersonaRepository personaRepository;

    public PersonaController(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @GetMapping
    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    @PostMapping
    public Persona create(@RequestBody Persona persona) {
        return personaRepository.save(persona);
    }
}