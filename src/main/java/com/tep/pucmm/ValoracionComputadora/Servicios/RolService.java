package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.Rol;
import com.tep.pucmm.ValoracionComputadora.Entidades.Usuario;
import com.tep.pucmm.ValoracionComputadora.Repositorio.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 18/10/18.
 */
@Service
@Transactional
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public long cantidadUsuario(){
        return rolRepository.count();
    }

    public Rol creacionRol(Rol rol){
        rolRepository.save(rol);
        return rol;
    }
    public void eliminarRolPorUsername(String username){
        rolRepository.deleteRolByUsername(username);
    }
    public void elimarRolPorId(Long id){
        rolRepository.deleteRolById(id);
    }
    public List<Rol> todosRoles(){
        return rolRepository.findAll();
    }
    public List<Rol> rolesUsuario(Usuario usuario){
        return rolRepository.findAllByUsername(usuario.getUsername());
    }


}
