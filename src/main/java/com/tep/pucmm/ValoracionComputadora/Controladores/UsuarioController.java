package com.tep.pucmm.ValoracionComputadora.Controladores;

import com.tep.pucmm.ValoracionComputadora.Entidades.Rol;
import com.tep.pucmm.ValoracionComputadora.Entidades.Usuario;
import com.tep.pucmm.ValoracionComputadora.Helpers.TipoHelper;
import com.tep.pucmm.ValoracionComputadora.Servicios.CorreoService;
import com.tep.pucmm.ValoracionComputadora.Servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.*;

/**
 * Created by Roman on 21/10/18.
 */
@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TipoHelper tipoHelper;

    @Autowired
    private CorreoService correoService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/{id}")
    public String verUsuario(Model model, @PathVariable Long id){
        model.addAttribute("usuario", usuarioService.buscarUnUsuario(id));

        model.addAttribute("usuarios", usuarioService.buscarTodosUsuarios());
        return "/ver/ver-usuario";
    }

    @GetMapping("/agregar")
    public String agregarUsuario(Model model){

        model.addAttribute("user", new Usuario());
        return "register";
    }

    @GetMapping("/roles/{id}")
    public String administrarUsuario(Principal user, @PathVariable("id")Long id, Model model){
        if(user!=null){
            model.addAttribute("usuario", usuarioService.buscarUsuarioPorUsername(user.getName()));
        }

        model.addAttribute("user", usuarioService.buscarUnUsuario(id));
        return "/actualizar/actualizar-usuario-roles";
    }

    // STOPSHIP: 25/11/18
    @PostMapping("/roles/actualizar")
    public String actualizarRolesUsuario(@ModelAttribute Usuario usuario,
                                         @RequestParam Map<String, String> requestParams,
                                         Model model) {
        if(usuario == null){
            model.addAttribute("error","no se pudo registrar.");
            model.addAttribute("user", usuarioService.buscarUnUsuario(tipoHelper.convertToLong(requestParams.get("id"))));
            return "/actualizar/actualizar-usuario-roles";
        }
        usuario = usuarioService.buscarUnUsuario(usuario.getId());
        if(requestParams.get("admin") !=null ){
            boolean esAdmin = true;
            for (Rol rol: usuario.getRoles()){
                esAdmin = false;
                if(rol.getRol().equals("ROLE_ADMIN")){
                    esAdmin = true;
                    break;
                }
            }
            if (!esAdmin){
                Rol r = new Rol();
                r.setRol("ROLE_ADMIN");
                usuario.getRoles().add(r);
            }
        }else {
            boolean esAdmin = true;
            for (Rol rol: usuario.getRoles()){
                esAdmin = false;
                if(rol.getRol().equals("ROLE_ADMIN")){
                    esAdmin = true;
                    break;
                }
            }
            if (esAdmin){
                List<Rol> rols = new ArrayList<>();
                for (Rol rol: usuario.getRoles()){
                    if(rol.getRol().equals("ROLE_USER")){
                       rols.add(rol);
                    }
                }
                usuario.setRoles(rols);
            }
        }

        usuarioService.guardarUsuario(usuario);

        return "redirect:/";
    }

    @PostMapping("/agregar")
    public ModelAndView agregarUsuario(@ModelAttribute Usuario usuario, @RequestParam("confirmPassword")String confirmPassword) {
        ModelAndView model = new ModelAndView();
        if(usuario.getUsername().isEmpty() || usuario.getEmail().isEmpty()){
                model.addObject("error","Nombre de usuario u correo no pueden ser nulos.");
                model.addObject("usuario", usuario);
                model.setViewName("register");
                return model;
        }
        if(usuario.getPassword().isEmpty()){
            model.addObject("error","Contrasena no puede ser nulo");
            model.addObject("usuario", usuario);
            model.setViewName("register");
            return model;
        }
        if (!usuario.getPassword().equals(confirmPassword)) {
            model.addObject("error", "Contraseñas diferentes");
            model.addObject("usuario", usuario);
            model.setViewName("register");
            return model;
        }
        Rol rol = new Rol();
        rol.setRol("ROLE_USER");
        List<Rol> rols = new ArrayList<>();
        rols.add(rol);
        usuario.setRoles(rols);
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        usuarioService.guardarUsuario(usuario);

        model.setViewName("redirect:/");
        return model;
    }

    @GetMapping("/actualizar/{id}")
    public String actualizarUsuario( Model model, @PathVariable("id") Long usuarioId){
        model.addAttribute("usuario", usuarioService.buscarUnUsuario(usuarioId));
        model.addAttribute("user", usuarioService.buscarUnUsuario(usuarioId));
        return "/actualizar/actualizar-usuario";
    }

    @PostMapping("/actualizar")
    public String actualizarUsuario(@ModelAttribute Usuario usuario,
                                    Model model) {
        if(usuario.getEmail().isEmpty()|| usuario.getEmail().isEmpty()){
                model.addAttribute("error","Nombre de usuario u correo no pueden ser nulos.");
                return "/actualizar/actualizar-usuario";
        }

        usuarioService.updateUsuario(usuario);

        return "redirect:/";
    }

    @RequestMapping("/eliminar/{id}/{idUsuario}")
    public String elimiarUsuario(@PathVariable Long id, @PathVariable("idUsuario") Long idLogeado) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuario/"+idLogeado;
    }

    // Rutina cuando el usuario olvida su contrasena
    @RequestMapping(value = "/olvidaContrasena", method = RequestMethod.GET)
    public ModelAndView paginaOlvidaContrasena() {
        return new ModelAndView("olvida_contrasena");
    }

    @RequestMapping(value = "/olvidaContrasena", method = RequestMethod.POST)
    public ModelAndView processForgotPasswordForm(ModelAndView modelAndView, @RequestParam("email") String correo, HttpServletRequest request) {

        // buscar por correo
        Optional<Usuario> optional = usuarioService.findUserByEmail(correo);

        if (!optional.isPresent()) {
            modelAndView.addObject("error", "No existe usuario con este correo.");
        } else {

            // Generar random de 36 caracteres para el  string token para reemplazar contrasena
            Usuario usuario = optional.get();
            usuario.setResetToken(UUID.randomUUID().toString());

            // guardar token del usuario
            usuarioService.guardarUsuario(usuario);

           // String appUrl = request.getScheme() + "://" + request.getServerName();

            // Email message
            SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
            passwordResetEmail.setFrom("supportValoracionComputadora@gmail.com");
            passwordResetEmail.setTo(usuario.getEmail());
            passwordResetEmail.setSubject("Solicitud de cambio de contrasena");
            passwordResetEmail.setText("Para cambiar tu contrasena, dale click en el enlace de abajo:\n" +
                    // appUrl
                    "http://localhost:3200/usuario"
                    + "/reset/" + usuario.getResetToken());

            correoService.enviarCorreo(passwordResetEmail);

            // Add success message to view
            modelAndView.addObject("success", "Un enlace de cambiar contrasena ha sido mandado a tu coreo: " + correo);
        }

        modelAndView.setViewName("olvida_contrasena");
        return modelAndView;

    }
    //  Formulario cambio contrasena
    @RequestMapping(value = "/reset/{token}", method = RequestMethod.GET)
    public ModelAndView displayResetPasswordPage(ModelAndView modelAndView, @PathVariable("token") String token) {

        Optional<Usuario> user = usuarioService.findUserByResetToken(token);

        if (user.isPresent()) { // Token found in DB
            modelAndView.addObject("resetToken", token);
        } else { // Token not found in DB
            modelAndView.addObject("error", "Oops! Este enlace de cambio de contrasena es incorrecto.");
        }

        modelAndView.setViewName("reset_contrasena");
        return modelAndView;
    }

    // Procesar cambio de contrasena formulario
    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public ModelAndView setNewPassword(ModelAndView modelAndView, @RequestParam(value = "token", required = false)String token, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {

        // Buscar usuario que corresponde con el token de cambio de contrasena
        Optional<Usuario> usuario = usuarioService.findUserByResetToken(requestParams.get("token"));

        // Este debe ser siempre no nulo pero se cheque por si acaso
        if (usuario.isPresent()) {

            Usuario resetUser = usuario.get();

            // agregar nueva contrasena
            resetUser.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));

            // Anular el token de cambio de contrasena para no volver a ser usado otra vez
            resetUser.setResetToken(null);

            // Guardar usuario
            usuarioService.guardarUsuario(resetUser);

            // Para agregar un modelo en un redirect se usa
            // RedirectAttributes
            redir.addFlashAttribute("success", "Su contrasena ha sido cambiado exitosamente! Usted puede abrir sesion ahora.");

            modelAndView.setViewName("redirect:/login");
            return modelAndView;

        } else {
            modelAndView.addObject("error", "Oops! Este enlace de cambio de contrasena es incorrecto.");
            modelAndView.setViewName("reset_contrasena");
        }

        return modelAndView;
    }

    // Going to reset page without a token redirects to login page
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
        return new ModelAndView("redirect:/login");
    }
}

