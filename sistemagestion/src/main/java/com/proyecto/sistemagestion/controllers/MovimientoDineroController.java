package com.proyecto.sistemagestion.controllers;

import com.proyecto.sistemagestion.entities.MovimientoDinero;
import com.proyecto.sistemagestion.services.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MovimientoDineroController {
    @Autowired
    MovimientoDineroService movimientoDineroService;

    @GetMapping("/movements")
    public List<MovimientoDinero> getMovimientos(){
        return movimientoDineroService.getMovimientosDinero();
    }

    @GetMapping("/movements/{id}")
    public MovimientoDinero getMovimientoById(@PathVariable("id") Integer id){
        return movimientoDineroService.getMovimientoById(id);
    }

    @GetMapping("/users/{id}/movements")
    public ArrayList<MovimientoDinero> getMovimientosByEmpleado(@PathVariable("id") Integer id){
        return movimientoDineroService.getMovimientosByEmpleado(id);
    }

    @GetMapping("/enterprises/{id}/movements")
    public ArrayList<MovimientoDinero> getMovimientosByEmpresa(@PathVariable("id") Integer id){
        return movimientoDineroService.getMovimientosByEmpresa(id);
    }

    @PostMapping("/movements")
    public String saveMovimiento(@RequestBody MovimientoDinero movimientoDinero){
        Boolean estado = movimientoDineroService.saveUpdateMovimiento(movimientoDinero);
        if(estado){
            return "Movimiento creado";
        }
        return "fallo al crear el movimiento";
    }

    @PatchMapping("/movements/{id}")
    public String editMovimiento(@RequestBody MovimientoDinero movimientoDinero, @PathVariable("id") Integer id){
        MovimientoDinero movi=movimientoDineroService.getMovimientoById(id);
        movi.setMonto(movimientoDinero.getMonto());
        movi.setConcepto(movimientoDinero.getConcepto());
        movi.setUsuario(movimientoDinero.getUsuario());
        Boolean estado = movimientoDineroService.saveUpdateMovimiento(movi);
        if(estado){
            return "Movimiento actualizado";
        }
        return "fallo al actualizar el movimiento";
    }

    @DeleteMapping("/movements/{id}")
    public String deleteMovimientoById(@PathVariable("id") Integer id){
        Boolean estado = movimientoDineroService.deleteMovimientoById(id);
        if (estado){
            return "Movimiento eliminado correctamente";
        }
        return "No se pudo eliminar el movimiento";
    }

}
