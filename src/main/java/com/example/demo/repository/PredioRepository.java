package com.example.demo.repository;

import com.example.demo.model.Predio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredioRepository extends JpaRepository<Predio, Long> {
}
