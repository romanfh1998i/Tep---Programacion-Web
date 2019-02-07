package com.tep.pucmm.ValoracionComputadora.Repositorio;

import com.tep.pucmm.ValoracionComputadora.Entidades.Puerto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Roman on 15/10/18.
 */
@Repository
public interface PuertoRepository extends JpaRepository<Puerto, Long> {
    List <Puerto> findAllByParteId(Long id);
    void deleteByParteId(Long id);
}
