package com.tep.pucmm.ValoracionComputadora.Controladores;

import com.tep.pucmm.ValoracionComputadora.Servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by Roman on 18/10/18.
 */
@Controller
public class IndexController {
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
    public ModelAndView paginaPrincipal(Model model, Principal user){
        if(user!=null){
            model.addAttribute("usuario", usuarioService.buscarUsuarioPorUsername(user.getName()));
        }
        return new ModelAndView("index");
    }

}
