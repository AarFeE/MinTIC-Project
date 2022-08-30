package com.proyecto.sistemagestion.repositories;

import com.proyecto.sistemagestion.entities.movimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoDineroRepository extends JpaRepository<movimientoDinero,Integer> {
}
