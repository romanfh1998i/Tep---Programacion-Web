package com.tep.pucmm.ValoracionComputadora.Repositorio;

import com.tep.pucmm.ValoracionComputadora.Entidades.Parte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Roman on 15/10/18.
 */
@Repository
public interface ParteRepository extends JpaRepository<Parte, Long> {
    List <Parte> findAllByComputadoraId(Long id);
    void deleteByComputadoraId(Long id);
}
