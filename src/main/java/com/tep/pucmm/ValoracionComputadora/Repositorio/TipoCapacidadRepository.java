package com.tep.pucmm.ValoracionComputadora.Repositorio;

import com.tep.pucmm.ValoracionComputadora.Entidades.TipoCapacidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Roman on 15/10/18.
 */
@Repository
public interface TipoCapacidadRepository extends JpaRepository<TipoCapacidad, Long>{
}
