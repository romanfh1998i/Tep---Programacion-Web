package com.tep.pucmm.ValoracionComputadora.Repositorio;

import com.tep.pucmm.ValoracionComputadora.Entidades.Bateria;
import com.tep.pucmm.ValoracionComputadora.Entidades.Puerto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Roman on 15/10/18.
 */
@Repository
public interface BateriaRepository extends JpaRepository<Bateria, Long> {
    List<Bateria> findAllByParteId(Long id);
    void deleteByParteId(Long id);
}
