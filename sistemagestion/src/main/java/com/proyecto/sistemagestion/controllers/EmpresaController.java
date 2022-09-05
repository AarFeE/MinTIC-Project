package com.proyecto.sistemagestion.controllers;

import com.proyecto.sistemagestion.entities.Empresa;
import com.proyecto.sistemagestion.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @GetMapping("/enterprises")
    public List<Empresa> getEmpresas(){
       return this.empresaService.getAllEmpresas();
    }

    @PostMapping("/enterprises")
    public Empresa saveEmpresa(@RequestBody Empresa empresa){
        return this.empresaService.saveOrUpdateEmpresa(empresa);
    }

    @GetMapping("/enterprises/{id}")
    public Empresa getEmpresaId(@PathVariable("id") Integer id){
        return this.empresaService.getEmpresaById(id);
    }

    @PatchMapping("/enterprises/{id}")
    public Empresa editEmpresa(@PathVariable("id") Integer id, @RequestBody Empresa empresa){
        Empresa Emp = this.empresaService.getEmpresaById(id);
        Emp.setNombre(empresa.getNombre());
        Emp.setDireccion(empresa.getDireccion());
        Emp.setTelefono(empresa.getTelefono());
        Emp.setNit(empresa.getNit());
        return this.empresaService.saveOrUpdateEmpresa(Emp);
    }

    @DeleteMapping("/enterprises/{id}")
    public String deleteEmpresa (@PathVariable("id") Integer id){
        boolean resp = this.empresaService.deleteEmpresa(id);
        if (resp == true){
            return "La empresa ha sido borrada";
        } else {
            return "La empresa NO ha sido borrada";
        }
    }
}
