package com.tep.pucmm.ValoracionComputadora.Repositorio;

import com.tep.pucmm.ValoracionComputadora.Entidades.TipoMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Roman on 16/10/18.
 */
@Repository
public interface TipoMaterialRepository extends JpaRepository<TipoMaterial, Long>{
}
