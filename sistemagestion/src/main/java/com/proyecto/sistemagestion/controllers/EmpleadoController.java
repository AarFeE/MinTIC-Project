package com.proyecto.sistemagestion.controllers;

import com.proyecto.sistemagestion.entities.Empleado;
import com.proyecto.sistemagestion.entities.Empresa;
import com.proyecto.sistemagestion.services.EmpleadoService;
import com.proyecto.sistemagestion.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @Autowired
    EmpresaService empresaService;

    @GetMapping("/usuarios")
    public String ViewUsuariosPage(Model model, @ModelAttribute("msg") String msg){
        List<Empleado> listaEmpleados=empleadoService.getAllEmpleados();
        model.addAttribute("userlist",listaEmpleados);
        model.addAttribute("msg",msg);
        return "viewUsuariosPage"; //Llamamos al HTML
    }

    @GetMapping("/nuevousuario")
    public String NewUsuarioPage(Model model, @ModelAttribute("msg") String msg){
        Empleado user= new Empleado();
        List<Empresa> listaEmpresas = empresaService.getAllEmpresas();
        model.addAttribute("user",user);
        model.addAttribute("msg",msg);
        model.addAttribute("emplist",listaEmpresas);
        return "newUsuarioPage";
    }

    @PostMapping("/guardarusuario")
    public String SaveUsuario(Empleado user, RedirectAttributes redirectAttributes){
        try{
            if(empleadoService.saveOrUpdateEmpleado(user)==true){
                redirectAttributes.addFlashAttribute("msg", "saveOK");
                return "redirect:/usuarios";
            } else{
                redirectAttributes.addFlashAttribute("msg", "saveERROR");
                return "redirect:/nuevousuario";
            }
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("msg", "saveREPEAT");
            return "redirect:/nuevousuario";
        }
    }

    @GetMapping("/editarusuario/{id}")
    public String EditUsuarioPage(Model model, @PathVariable Integer id, @ModelAttribute("msg") String msg){
        Empleado user=empleadoService.getEmpleadoById(id);
        List<Empresa> listaEmpresas = empresaService.getAllEmpresas();
        model.addAttribute("emplist",listaEmpresas);
        model.addAttribute("user",user);
        model.addAttribute("msg", msg);
        return "editUsuarioPage";
    }

    @PostMapping("/actualizarusuario")
    public String UpdateUsuario(@ModelAttribute("emp") Empleado user, RedirectAttributes redirectAttributes) {
        try {
            if (empleadoService.saveOrUpdateEmpleado(user) == true) {
                redirectAttributes.addFlashAttribute("msg", "updtOK");
                return "redirect:/usuarios";
            } else {
                redirectAttributes.addFlashAttribute("msg", "updtERROR");
                return "redirect:/editarusuario/"+user.getId();
            }

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msg", "updtREPEAT");
            return "redirect:/editarusuario/"+user.getId();
        }
    }

    @GetMapping("/eliminarusuario/{id}")
    public String DeleteUsuario(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if (empleadoService.deleteEmpleado(id)==true){
            redirectAttributes.addFlashAttribute("msg", "dltOK");
            return "redirect:/usuarios";
        }
        redirectAttributes.addFlashAttribute("msg", "dltEROR");
        return "redirect:/usuarios";
    }

}
