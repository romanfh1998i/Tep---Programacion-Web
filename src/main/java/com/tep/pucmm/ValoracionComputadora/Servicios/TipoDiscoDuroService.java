package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.TipoDiscoDuro;
import com.tep.pucmm.ValoracionComputadora.Repositorio.TipoDiscoDuroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 18/10/18.
 */
@Service
@Transactional
public class TipoDiscoDuroService {
    @Autowired
    private TipoDiscoDuroRepository tipoDiscoDuroRepository;

    public List<TipoDiscoDuro> obtenerTipoDiscoDuros(){
        return tipoDiscoDuroRepository.findAll();
    }

    public TipoDiscoDuro obtenerTipoDiscoDuro(Long id){
        return tipoDiscoDuroRepository.findOne(id);
    }


    public TipoDiscoDuro guardarTipoDiscoDuro(TipoDiscoDuro tipoDiscoDuro){
        return tipoDiscoDuroRepository.save(tipoDiscoDuro);
    }

    public void eliminarTipoDiscoDuro(Long id){
        tipoDiscoDuroRepository.delete(id);
    }
}
