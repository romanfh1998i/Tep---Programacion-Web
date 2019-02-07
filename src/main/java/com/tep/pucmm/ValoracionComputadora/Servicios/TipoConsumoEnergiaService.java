package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.TipoConsumoEnergia;
import com.tep.pucmm.ValoracionComputadora.Repositorio.TipoConsumoEnergiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 18/10/18.
 */
@Service
@Transactional
public class TipoConsumoEnergiaService {
    @Autowired
    private TipoConsumoEnergiaRepository tipoConsumoEnergiaRepository;

    public List<TipoConsumoEnergia> obtenerTipoConsumoEnergias(){
        return tipoConsumoEnergiaRepository.findAll();
    }

    public TipoConsumoEnergia obtenerTipoConsumoEnergia(Long id){
        return tipoConsumoEnergiaRepository.findOne(id);
    }


    public TipoConsumoEnergia guardarTipoConsumoEnergia(TipoConsumoEnergia tipoConsumoEnergia){
        return tipoConsumoEnergiaRepository.save(tipoConsumoEnergia);
    }

    public void eliminarTipoConsumoEnergia(Long id){
        tipoConsumoEnergiaRepository.delete(id);
    }
    
}
