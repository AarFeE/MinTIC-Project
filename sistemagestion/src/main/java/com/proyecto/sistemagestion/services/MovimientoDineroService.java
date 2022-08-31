package com.proyecto.sistemagestion.services;

import com.proyecto.sistemagestion.entities.Empresa;
import com.proyecto.sistemagestion.entities.MovimientoDinero;
import com.proyecto.sistemagestion.repositories.MovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoDineroService {

    @Autowired
    MovimientoDineroRepository movimientoRepository;

    public List<MovimientoDinero>  getMovimientosDinero(){
        List<MovimientoDinero> movimientosList = new ArrayList<>();
        movimientoRepository.findAll().forEach(movimiento -> movimientosList.add(movimiento));
        return movimientosList;
    }

    public MovimientoDinero getMovimientoById(Integer id){
        return movimientoRepository.findById(id).get();
    }

    public boolean saveUpdateMovimiento(MovimientoDinero movimiento){
        MovimientoDinero temp = movimientoRepository.save(movimiento);
        if(movimientoRepository.findById(temp.getId()) != null){
            return true;
        } else{
            return false;
        }
    }

    public boolean deleteMovimientoById(Integer id){
        movimientoRepository.deleteById(id);
        if(getMovimientoById(id) != null){
            return false;
        } else{
            return true;
        }
    }
}
