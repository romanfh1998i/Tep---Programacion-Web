package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.TipoRefrescante;
import com.tep.pucmm.ValoracionComputadora.Repositorio.TipoRefrescanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 18/10/18.
 */
@Service
@Transactional
public class TipoRefrescanteService {
    @Autowired
    private TipoRefrescanteRepository tipoRefrescanteRepository;

    public List<TipoRefrescante> obtenerTipoRefrescantes(){
        return tipoRefrescanteRepository.findAll();
    }

    public TipoRefrescante obtenerTipoRefrescante(Long id){
        return tipoRefrescanteRepository.findOne(id);
    }


    public TipoRefrescante guardarTipoRefrescante(TipoRefrescante tipoRefrescante){
        return tipoRefrescanteRepository.save(tipoRefrescante);
    }

    public void eliminarTipoRefrescante(Long id){
        tipoRefrescanteRepository.delete(id);
    }
}
