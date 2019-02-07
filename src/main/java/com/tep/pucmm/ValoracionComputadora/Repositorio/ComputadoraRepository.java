package com.tep.pucmm.ValoracionComputadora.Repositorio;

import com.tep.pucmm.ValoracionComputadora.Entidades.Computadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Roman on 15/10/18.
 */
@Repository
public interface ComputadoraRepository extends JpaRepository<Computadora, Long> {
    Computadora findByUsuario(Long usuario);
    List<Computadora> findAllByUsuario(Long usuario);
    void deleteByUsuario(Long id);
}
