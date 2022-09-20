package com.proyecto.sistemagestion.controllers;

import com.proyecto.sistemagestion.entities.Empresa;
import com.proyecto.sistemagestion.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @GetMapping("/empresas")
    public String ViewEmpresasPage(Model model, @ModelAttribute("msg") String msg){
        List<Empresa> listaEmpresas=empresaService.getAllEmpresas();
        model.addAttribute("emplist",listaEmpresas);
        model.addAttribute("msg",msg);
        return "viewEmpresasPage"; //Llamamos al HTML
    }

}
