package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.TipoComputadora;
import com.tep.pucmm.ValoracionComputadora.Repositorio.TipoComputadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 18/10/18.
 */
@Service
@Transactional
public class TipoComputadoraService {
    /**
     *
     */
    @Autowired
    private TipoComputadoraRepository tipoComputadoraRepository;

    public List<TipoComputadora> obtenerTipoComputadoras(){
        return tipoComputadoraRepository.findAll();
    }

    public TipoComputadora obtenerTipoComputadora(Long id){
        return tipoComputadoraRepository.findOne(id);
    }


    public TipoComputadora guardarTipoComputadora(TipoComputadora tipoComputadora){
        return tipoComputadoraRepository.save(tipoComputadora);
    }

    public void eliminarTipoComputadora(Long id){
        tipoComputadoraRepository.delete(id);
    }
}
