package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.Computadora;
import com.tep.pucmm.ValoracionComputadora.Entidades.Rol;
import com.tep.pucmm.ValoracionComputadora.Entidades.Usuario;
import com.tep.pucmm.ValoracionComputadora.Repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Roman on 18/10/18.
 */
@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolService rolServices;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UsuarioService usuarioServices;

    @Autowired
    private ComputadoraService computadoraService;

    public void  eliminarUsuario(Long id){
        computadoraService.eliminarComputadoraPorUsuario(id);
        Usuario usuario = usuarioRepository.findById(id);
        for(Rol rol: usuario.getRoles())
        {
            rolServices.elimarRolPorId(rol.getId());
        }
        usuarioRepository.deleteById(id);
    }

    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuarioPorUsername(String username){
        return usuarioRepository.findByUsername(username);
    }

    public Page<Usuario> buscarUsuarios(int page, int itemPerPage){
        Pageable pageable = new PageRequest(page,itemPerPage);
        return usuarioRepository.findAll(pageable);
    }

    public List<Usuario> buscarTodosUsuarios(){
        return usuarioRepository.findAll();
    }

    public List<Usuario> buscarUsuarioPorNombreUsuario(String username){
        return usuarioRepository.findAllByUsername(username);
    }

    public void eliminarUsuarioPorId(Long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario updateUsuario(Usuario user){
        Usuario currentUser = usuarioRepository.findById(user.getId());
        currentUser.setEnable(user.getEnable());
        currentUser.setName(user.getName());
        currentUser.setEmail(user.getEmail());
        return usuarioRepository.save(currentUser);

    }
    public Optional findUserByResetToken(String resetToken) {
        return usuarioRepository.findByResetToken(resetToken);
    }

   public Optional findUserByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }


    public Usuario buscarUnUsuario(Long id){
        return usuarioRepository.findById(id);
    }

    public void crearAdmin(){
        List<Usuario> usuarios = usuarioRepository.findAllByUsername("admin");
        System.out.println(usuarios.size() +"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++=");
        //usuarios.get(0).getRoles().forEach(rol ->  System.out.println(rol.getRol() +"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++="));

        if(usuarios.size()<1){
            System.out.println("There+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            Usuario usuario =  new Usuario();
            usuario.setName("Roman");
            usuario.setEmail("romanfh1998@gmail.com");
            usuario.setUsername("admin");
            usuario.setPassword(bCryptPasswordEncoder.encode("rfranco"));
            guardarUsuario(usuario);
            Rol rol = new Rol();
            rol.setRol("ROLE_ADMIN");
            rol.setUsername(usuario.getUsername());
            Rol rol2 = new Rol();
            rol2.setRol("ROLE_USER");
            rol2.setUsername(usuario.getUsername());
            //rolServices.creacionRol(rol);
            List<Rol> rols = new ArrayList<>();
            rols.add(rol);
            rols.add(rol2);
            usuario.setRoles(rols);
            usuarioServices.guardarUsuario(usuario);
        }
    }
}
