package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.TipoMemoria;
import com.tep.pucmm.ValoracionComputadora.Repositorio.TipoMemoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 18/10/18.
 */
@Service
@Transactional
public class TipoMemoriaService {
    @Autowired
    private TipoMemoriaRepository tipoMemoriaRepository;

    public List<TipoMemoria> obtenerTipoMemorias(){
        return tipoMemoriaRepository.findAll();
    }

    public TipoMemoria obtenerTipoMemoria(Long id){
        return tipoMemoriaRepository.findOne(id);
    }


    public TipoMemoria guardarTipoMemoria(TipoMemoria tipoMemoria){
        return tipoMemoriaRepository.save(tipoMemoria);
    }

    public void eliminarTipoMemoria(Long id){
        tipoMemoriaRepository.delete(id);
    }
}
