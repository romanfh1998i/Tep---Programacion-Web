package com.tep.pucmm.ValoracionComputadora.Repositorio;

import com.tep.pucmm.ValoracionComputadora.Entidades.TipoTipoRendimientoPrecio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Romna on 16/10/18.
 */
@Repository
public interface TipoTipoRendimientoPrecioRepository extends JpaRepository<TipoTipoRendimientoPrecio, Long>{
}
