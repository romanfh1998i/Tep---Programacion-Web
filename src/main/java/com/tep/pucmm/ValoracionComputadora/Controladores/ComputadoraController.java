package com.tep.pucmm.ValoracionComputadora.Controladores;

import com.tep.pucmm.ValoracionComputadora.Entidades.Computadora;
import com.tep.pucmm.ValoracionComputadora.Entidades.Usuario;
import com.tep.pucmm.ValoracionComputadora.Helpers.EntityHelper;
import com.tep.pucmm.ValoracionComputadora.Helpers.TipoHelper;
import com.tep.pucmm.ValoracionComputadora.Helpers.TipoObject;
import com.tep.pucmm.ValoracionComputadora.Servicios.ComputadoraService;
import com.tep.pucmm.ValoracionComputadora.Servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RequestWrapper;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Roman on 18/10/18.
 */
@Controller
@RequestMapping("/computadora")
public class ComputadoraController {
    @Autowired
    private EntityHelper entityHelper;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TipoHelper tipoHelper;


    @RequestMapping("/")
    public String verComputadora(Model model, Principal user) {
        Usuario usuario = new Usuario();
        if (user != null) {
            usuario = usuarioService.buscarUsuarioPorUsername(user.getName());
            model.addAttribute("usuario", usuario);
        }

        TipoObject tipoObject = tipoHelper.getHelperObject("ver", "computadora", usuario.getId());
        if (tipoObject.getObjeto() != null)
            model.addAttribute("computadoras", tipoObject.getObjeto());
        return tipoObject.getActionName();

    }

    @RequestMapping("/agregar")
    public String agregarComputadora(Model model, Principal user) {
        if (user != null) {
            model.addAttribute("usuario", usuarioService.buscarUsuarioPorUsername(user.getName()));
        }
        TipoObject tipoObject = tipoHelper.getHelperObject("crear", "computadora", (long) 0);

        if (tipoObject.getObjeto() != null)
            model.addAttribute("computadora", tipoObject.getObjeto());
        Map<String, Object> entidades = entityHelper.getEntity("computadora");
        if (entidades != null)
            for (String key : entidades.keySet())
                model.addAttribute(key, entidades.get(key));

        return tipoObject.getActionName();
    }

    @PostMapping("/agregar")
    public String agregarObjeto(Principal user,Model model,@ModelAttribute("computadora") Computadora computadora) {
        Map<String, Object> relaciones = new HashMap<>();
        if (user != null) {
            model.addAttribute("usuario", usuarioService.buscarUsuarioPorUsername(user.getName()));
            relaciones.put("usuario", user.getName());
        }

        if (tipoHelper.helperAddUpdate(computadora, relaciones) == null) {
            Map<String, Object> entidades = entityHelper.getEntity("computadora");
            if (entidades != null)
                for (String key : entidades.keySet())
                    model.addAttribute(key, entidades.get(key));
            model.addAttribute("error", "No se pudo guardar");
            return tipoHelper.getHelperView("crear", "computadora");
        }

        return "redirect:/computadora/";
    }

    @RequestMapping("/actualizar/{id}")
    public String actualizarComputadora(Model model, @PathVariable Long id, Principal user) {
        if (user != null) {
            model.addAttribute("usuario", usuarioService.buscarUsuarioPorUsername(user.getName()));
        }
        TipoObject tipoObject = tipoHelper.getHelperObject("actualizar", "computadora", id);

        if (tipoObject.getObjeto() != null)
            model.addAttribute("computadora", tipoObject.getObjeto());

        Map<String, Object> entidades = entityHelper.getEntity("computadora");
        if (entidades != null)
            for (String key : entidades.keySet())
                model.addAttribute(key, entidades.get(key));

        return tipoObject.getActionName();
    }

    @PostMapping("/actualizar")
    public String actualizarComputadora(Principal user,Model model,@ModelAttribute("computadora") Computadora computadora) {
        Map<String, Object> relaciones = new HashMap<>();
        if (user != null) {
            model.addAttribute("usuario", usuarioService.buscarUsuarioPorUsername(user.getName()));
            relaciones.put("usuario", user.getName());
        }

        if (tipoHelper.helperAddUpdate(computadora, relaciones) == null) {
            model.addAttribute("error", "No se pudo actualizar");
            Map<String, Object> entidades = entityHelper.getEntity("computadora");
            if (entidades != null)
                for (String key : entidades.keySet())
                    model.addAttribute(key, entidades.get(key));

            return tipoHelper.getHelperView("crear", "computadora");
        }

        return "redirect:/computadora/";
    }

    @RequestMapping("/eliminar/{id}")
    public String elimiarComputadora(@PathVariable Long id) {
        tipoHelper.eliminarEntidiad("computadora", id);
        return "redirect:/computadora/";
    }

}