package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "predio")
public class Predio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double area;
    private String ciudad;

    @ManyToOne
    @JoinColumn(name = "duenio_id", nullable = false)
    private Persona duenio;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getArea() { return area; }
    public void setArea(Double area) { this.area = area; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public Persona getDuenio() { return duenio; }
    public void setDuenio(Persona duenio) { this.duenio = duenio; }
}
