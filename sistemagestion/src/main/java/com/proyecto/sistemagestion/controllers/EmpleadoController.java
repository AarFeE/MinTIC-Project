package com.proyecto.sistemagestion.controllers;


import com.proyecto.sistemagestion.entities.Empleado;
import com.proyecto.sistemagestion.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/empleados")
    public List<Empleado> getEmpleado(){
        return  this.empleadoService.getAllEmpleados();
    }

    @PostMapping("/empleados")
    public boolean saveEmpleado(@RequestBody Empleado empleado){
        return this.empleadoService.saveOrUpdateEmpleado(empleado);
    }

    @GetMapping("/empleados/{id}")
    public Empleado getEmpleadoID(@PathVariable("id") Integer id){
        return this.empleadoService.getEmpleadoById(id);
    }

    @PatchMapping("/empleados/{id}")
    public boolean editEmpleado(@PathVariable("id") Integer id, @RequestBody Empleado empleado){
        Empleado Empl = this.empleadoService.getEmpleadoById(id);
        Empl.setNombre(empleado.getNombre());
        Empl.setCorreo(empleado.getCorreo());
        Empl.setId(empleado.getId());
        return this.empleadoService.saveOrUpdateEmpleado(Empl);
    }

    @DeleteMapping("/empleados/{id}")
    public String deleteEmpleado (@PathVariable("id") Integer id){
        boolean resp = this.empleadoService.deleteEmpleado(id);
        if (resp == true){
            return "El empleado ha sido borrado";
        } else {
            return "El empleado NO ha sido borrado";
        }
    }
}
