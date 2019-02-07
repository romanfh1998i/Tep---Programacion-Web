package com.tep.pucmm.ValoracionComputadora.Controladores;

import com.tep.pucmm.ValoracionComputadora.Entidades.Computadora;
import com.tep.pucmm.ValoracionComputadora.Entidades.Parte;
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
import java.util.List;
import java.util.Map;

/**
 * Created by Roman on 18/10/18.
 */
@Controller
@RequestMapping("/parte")
public class ParteController {
    @Autowired
    private EntityHelper entityHelper;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TipoHelper tipoHelper;

    @Autowired
    private ComputadoraService computadoraService;


    @RequestMapping("/{id}")
    public String verParte(Model model, Principal user, @PathVariable("id") Long computadoraId) {

        if (user != null) {
            model.addAttribute("usuario", usuarioService.buscarUsuarioPorUsername(user.getName()));
        }

        TipoObject tipoObject = tipoHelper.getHelperObject("ver", "parte", computadoraId );

        if (tipoObject.getObjeto() != null){
            Map<String, Object> entidades = entityHelper.getEntityByObject((List<Parte>) tipoObject.getObjeto());
            for (String key : entidades.keySet())
                model.addAttribute(key, entidades.get(key));
            model.addAttribute("partes", tipoObject.getObjeto());
            model.addAttribute("computadoraId", computadoraId);
        }
        return tipoObject.getActionName();

    }
    /*
    * Param id
    * Usado para obtener la computadora en cuestion
    * */

    @RequestMapping("/agregar/{id}")
    public String agregarParte(Model model, Principal user, @PathVariable Long id) {
        if (user != null) {
            model.addAttribute("usuario", usuarioService.buscarUsuarioPorUsername(user.getName()));
        }
        TipoObject tipoObject = tipoHelper.getHelperObject("crear", "parte", id);

        if (tipoObject.getObjeto() != null)
            model.addAttribute("parte", tipoObject.getObjeto());
        Map<String, Object> entidades = entityHelper.getEntity("parte");
        if (entidades != null)
            for (String key : entidades.keySet())
                model.addAttribute(key, entidades.get(key));

        return tipoObject.getActionName();
    }

    @PostMapping("/agregar")
    public String agregarParte(Principal user, Model model, @ModelAttribute("parte") Parte parte, @RequestParam("computadora") Long computadoraId) {
        Map<String, Object> relaciones = new HashMap<>();
        if (user != null) {
            model.addAttribute("usuario", usuarioService.buscarUsuarioPorUsername(user.getName()));
            relaciones.put("usuario", user.getName());
        }
        parte.setComputadora(computadoraService.obtenerComputadora(computadoraId));
        if (tipoHelper.helperAddUpdate(parte, relaciones) == null) {
            model.addAttribute("error", "No se pudo guardar");
            return tipoHelper.getHelperView("crear", "parte");
        }
        Map<String, Object> entidades = entityHelper.getEntity("parte");
        if (entidades != null) {
            for (String key : entidades.keySet())
                model.addAttribute(key, entidades.get(key));
        }
//        model.addAttribute("computadoraId", computadoraId);

        return "redirect:/parte/"+computadoraId;
    }

    @RequestMapping("/actualizar/{id}")
    public String actualizarParte(Model model, @PathVariable Long id, Principal user) {
        if (user != null) {
            model.addAttribute("usuario", usuarioService.buscarUsuarioPorUsername(user.getName()));
        }
        TipoObject tipoObject = tipoHelper.getHelperObject("actualizar", "parte", id);

        if (tipoObject.getObjeto() != null)
            model.addAttribute("parte", tipoObject.getObjeto());

        Map<String, Object> entidades = entityHelper.getEntity("parte");
        if (entidades != null)
            for (String key : entidades.keySet())
                model.addAttribute(key, entidades.get(key));

        return tipoObject.getActionName();
    }

    @PostMapping("/actualizar")
    public String actualizarParte(Principal user,Model model,@ModelAttribute("parte") Parte parte) {
        Map<String, Object> relaciones = new HashMap<>();
        if (user != null) {
            model.addAttribute("usuario", usuarioService.buscarUsuarioPorUsername(user.getName()));
            relaciones.put("usuario", user.getName());
        }

        if (tipoHelper.helperAddUpdate(parte, relaciones) == null) {
            model.addAttribute("error", "No se pudo actualizar");
            Map<String, Object> entidades = entityHelper.getEntity("parte");
            if (entidades != null)
                for (String key : entidades.keySet())
                    model.addAttribute(key, entidades.get(key));

            return tipoHelper.getHelperView("crear", "parte");
        }

        return "redirect:/parte/";
    }

    @RequestMapping("/eliminar/{id}")
    public String elimiarParte(@PathVariable Long id) {
        tipoHelper.eliminarEntidiad("parte", id);
        return "redirect:/computadora/";
    }

}