package com.proyecto.sistemagestion.repositories;

import com.proyecto.sistemagestion.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoDineroRepository extends JpaRepository<MovimientoDinero,Integer> {
}
