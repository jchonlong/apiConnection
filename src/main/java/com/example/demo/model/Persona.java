package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String ciudad;

    @OneToMany(mappedBy = "duenio", cascade = CascadeType.ALL)
    private List<Predio> predios;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public List<Predio> getPredios() { return predios; }
    public void setPredios(List<Predio> predios) { this.predios = predios; }
}
