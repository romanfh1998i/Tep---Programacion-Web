package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.TipoCapacidad;
import com.tep.pucmm.ValoracionComputadora.Repositorio.TipoCapacidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 18/10/18.
 */
@Service
@Transactional
public class TipoCapacidadService {
    @Autowired
    private TipoCapacidadRepository tipoCapacidadRepository;

    public List<TipoCapacidad> obtenerTipoCapacidads(){
        return tipoCapacidadRepository.findAll();
    }

    public TipoCapacidad obtenerTipoCapacidad(Long id){
        return tipoCapacidadRepository.findOne(id);
    }


    public TipoCapacidad guardarTipoCapacidad(TipoCapacidad tipoCapacidad){
        return tipoCapacidadRepository.save(tipoCapacidad);
    }

    public void eliminarTipoCapacidad(Long id){
        tipoCapacidadRepository.delete(id);
    }
}
