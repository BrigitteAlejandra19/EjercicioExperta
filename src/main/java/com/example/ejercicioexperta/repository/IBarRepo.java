package com.example.ejercicioexperta.repository;

import com.example.ejercicioexperta.entity.Bar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBarRepo extends JpaRepository<Bar, Integer> {
}
