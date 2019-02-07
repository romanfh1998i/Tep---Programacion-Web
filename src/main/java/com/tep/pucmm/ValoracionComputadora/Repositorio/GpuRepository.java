package com.tep.pucmm.ValoracionComputadora.Repositorio;

import com.tep.pucmm.ValoracionComputadora.Entidades.Gpu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Roman on 15/10/18.
 */
@Repository
public interface GpuRepository extends JpaRepository<Gpu, Long> {
    List<Gpu> findAllByParteId(Long id);
    void deleteByParteId(Long id);
}
