package com.tep.pucmm.ValoracionComputadora.Controladores;

import com.tep.pucmm.ValoracionComputadora.Entidades.Parte;
import com.tep.pucmm.ValoracionComputadora.Entidades.Usuario;
import com.tep.pucmm.ValoracionComputadora.Helpers.EntityHelper;
import com.tep.pucmm.ValoracionComputadora.Helpers.TipoHelper;
import com.tep.pucmm.ValoracionComputadora.Helpers.TipoObject;
import com.tep.pucmm.ValoracionComputadora.Servicios.ParteService;
import com.tep.pucmm.ValoracionComputadora.Servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.WebRequestDataBinder;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Roman on 27/10/18.
 */

@Controller
@RequestMapping(value = "/{tablename}")
public class TableController {
    @Autowired
    private TipoHelper tipoHelper;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private EntityHelper entityHelper;
    @Autowired
    private ParteService parteService;

    @RequestMapping("/")
    public String verUsuario(Model model, @PathVariable String tablename, Principal user){
        Usuario usuario = new Usuario();
        if(user!=null){
            usuario =  usuarioService.buscarUsuarioPorUsername(user.getName());
            model.addAttribute("usuario",usuario);
        }
        TipoObject tipoObject = tipoHelper.getHelperObject("ver",tablename, usuario.getId());
        if(!tablename.isEmpty()){
            model.addAttribute(tablename, tipoObject.getObjeto());
            return tipoObject.getActionName();
        }
        return "404";
    }

    @GetMapping("/agregar")
    public ModelAndView agregarObjeto( @PathVariable String tablename, Principal user){
        //TipoHelper tipoHelper = new TipoHelper();
        ModelAndView model = new ModelAndView();
        if(user!=null){
            model.addObject("usuario", usuarioService.buscarUsuarioPorUsername(user.getName()));
        }

        TipoObject tipoObject = tipoHelper.getHelperObject("crear",tablename, (long) 0);
        if(!tablename.isEmpty()){
            if(tipoObject.getObjeto() !=null)
                model.addObject(tablename, tipoObject.getObjeto());
            Map<String , Object>  entidades = entityHelper.getEntity(tablename);
            if(entidades !=null)
                for(String key: entidades.keySet())
                    model.addObject(key, entidades.get(key));
            model.setViewName(tipoObject.getActionName());
            return model ;
        }
        model.setViewName("404");
        return model;
    }

    @GetMapping("/crear/{id}")
    public String crearParte( @PathVariable("tablename") String tablename,
                                    @PathVariable("id")Long parteId,
                                    Model model,
                                    Principal user){

        if(user!=null){
            model.addAttribute("usuario", usuarioService.buscarUsuarioPorUsername(user.getName()));
        }

        TipoObject tipoObject = tipoHelper.getHelperObject("crear",tablename, parteId);

        if(!tablename.isEmpty()){
            Map<String , Object>  entidades = entityHelper.getEntity(tablename);
            if(tipoObject.getObjeto() !=null)
                model.addAttribute(tablename, tipoObject.getObjeto());
            if(entidades !=null)
                for(String key: entidades.keySet())
                    model.addAttribute(key, entidades.get(key));
            if(entityHelper.esParte(tablename))
                model.addAttribute("parteId", parteId);
            return tipoObject.getActionName();
        }
        return  "404";
    }

    @PostMapping("/agregar")
    public String  agregarObjeto(Principal user,
                                 Model model,
                                 @RequestParam Map<String, String> requestParams,
                                 @RequestParam(value = "parte", required = false) Long parteId,
                                 WebRequest request,
                                 @PathVariable String tablename)
    {
        Object domainObject = tipoHelper.getHelperObject("crear", tablename, (long)0).getObjeto();

        WebRequestDataBinder binder = new WebRequestDataBinder(domainObject);
        if(user!=null){
            model.addAttribute("usuario", usuarioService.buscarUsuarioPorUsername(user.getName()));
        }

        binder.bind(request);
 //       Id's checking  Area begin-----------------------------------------------------
        Map<String, Object> relaciones = new HashMap<>();

        if(entityHelper.esParte(tablename)
                || tablename.equals("tipoGpu")
                || tablename.equals("tipoCpu")){
            relaciones.put("parte", parteId);
            if(!requestParams.isEmpty()){
                for(String key: requestParams.keySet())
                    relaciones.put(key, requestParams.get(key));
            }
        }
//       Id's checking  Area End-----------------------------------------------------

        if(tipoHelper.helperAddUpdate(domainObject, relaciones)==null){
            model.addAttribute("error", "No se pudo guardar");
            TipoObject tipoObject = tipoHelper.getHelperObject("crear",tablename, (long) 0);
            if(tipoObject.getObjeto() !=null)
                model.addAttribute(tablename, tipoObject.getObjeto());
            Map<String , Object>  entidades = entityHelper.getEntity(tablename);
            if(entidades !=null)
                for(String key: entidades.keySet())
                    model.addAttribute(key, entidades.get(key));
            return tipoHelper.getHelperView("crear", tablename);
        }

        if(entityHelper.esParte(tablename)){
            Parte parte = parteService.obtenerParte(parteId);
            return "redirect:/parte/"+parte.getComputadora().getId();
        }

        return "redirect:/"+ tablename + "/";
    }

    @GetMapping("/actualizar/{parte}/{id}")
    public String actualizarObjeto(Principal user, Model model,
                                   @PathVariable String tablename,
                                   @PathVariable("parte") Long parte,
                                   @PathVariable("id") Long id){
        if(user!=null){
            model.addAttribute("usuario", usuarioService.buscarUsuarioPorUsername(user.getName()));
        }
        if(id == null || id == 0){
            model.addAttribute("error", "Elemento con: " + id + " no encontrado.");
            return "not_found";
        }

        TipoObject tipoObject = tipoHelper.getHelperObject("actualizar",tablename, id);

        if(!tablename.isEmpty()){
            model.addAttribute("parteId", parte);
            if(tipoObject.getObjeto() !=null)
                model.addAttribute(tablename, tipoObject.getObjeto());
            Map<String , Object>  entidades = entityHelper.getEntity(tablename);
            if(entidades !=null)
                for(String key: entidades.keySet())
                    model.addAttribute(key, entidades.get(key));

            return tipoObject.getActionName();
        }
        return "404";
    }

    @PostMapping("/actualizar")
    public String actualizarObjeto(Principal user,
                                   @PathVariable String tablename,
                                   @RequestParam Map<String, String> requestParams,
                                   WebRequest request,
                                   Model model) {

        Object domainObject = tipoHelper.getHelperObject("crear", tablename, (long)0).getObjeto();
        WebRequestDataBinder binder = new WebRequestDataBinder(domainObject);
        binder.bind(request);

        Map<String, Object> relaciones = new HashMap<>();

        if(entityHelper.esParte(tablename)
                || tablename.equals("tipoGpu")
                || tablename.equals("tipoCpu")){
            if(!requestParams.isEmpty()){
                for(String key: requestParams.keySet())
                    relaciones.put(key, requestParams.get(key));
            }
        }

        if(tipoHelper.helperAddUpdate(domainObject, relaciones)!= null){
            Parte parte = parteService.obtenerParte(tipoHelper.convertToLong(requestParams.get("parte")));
            return "redirect:/parte/"+parte.getComputadora().getId();
        }

        if(user!=null){
            model.addAttribute("usuario", usuarioService.buscarUsuarioPorUsername(user.getName()));
        }

        Map<String , Object>  entidades = entityHelper.getEntity(tablename);
        if(entidades !=null)
            for(String key: entidades.keySet())
                model.addAttribute(key, entidades.get(key));
        model.addAttribute("error", "No se pudo actualizar.");
        return tipoHelper.getHelperView("actualizar", tablename);
    }

    @PostMapping("/eliminar/{id}")
    public String elimiarEntidad(@PathVariable("tablename")String tablename, @PathVariable Long id) {
        tipoHelper.eliminarEntidiad(tablename, id);
        return "redirect:/"+tablename+"/";
    }

    @RequestMapping("/eliminar/{id}/{computadoraId}")
    public String elimiarParte(@PathVariable("tablename")String tablename,
                               @PathVariable("id") Long id,
                               @PathVariable("computadoraId")Long computadoraId) {
          tipoHelper.eliminarEntidiad(tablename, id);
          return "redirect:/parte/"+computadoraId;
    }


}

