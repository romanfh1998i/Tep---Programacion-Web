package com.tep.pucmm.ValoracionComputadora.Repositorio;

import com.tep.pucmm.ValoracionComputadora.Entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Roman on 15/10/18.
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{

    List<Rol> findAll();

    List<Rol> findAllByUsername(String Username);

    void deleteRolById(Long id);

    void deleteRolByUsername(String username);
}
