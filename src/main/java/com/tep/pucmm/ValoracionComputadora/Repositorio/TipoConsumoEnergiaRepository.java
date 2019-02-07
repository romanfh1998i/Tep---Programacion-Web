package com.tep.pucmm.ValoracionComputadora.Repositorio;

import com.tep.pucmm.ValoracionComputadora.Entidades.TipoConsumoEnergia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Roman on 15/10/18.
 */
@Repository
public interface TipoConsumoEnergiaRepository extends JpaRepository<TipoConsumoEnergia, Long> {
}
