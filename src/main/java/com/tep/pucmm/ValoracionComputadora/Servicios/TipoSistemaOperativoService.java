package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.TipoSistemaOperativo;
import com.tep.pucmm.ValoracionComputadora.Repositorio.TipoSistemaOperativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 18/10/18.
 */
@Service
@Transactional
public class TipoSistemaOperativoService {
    @Autowired
    private TipoSistemaOperativoRepository tipoSistemaOperativoRepository;

    public List<TipoSistemaOperativo> obtenerTipoSistemaOperativos(){
        return tipoSistemaOperativoRepository.findAll();
    }

    public TipoSistemaOperativo obtenerTipoSistemaOperativo(Long id){
        return tipoSistemaOperativoRepository.findOne(id);
    }


    public TipoSistemaOperativo guardarTipoSistemaOperativo(TipoSistemaOperativo tipoSistemaOperativo){
        return tipoSistemaOperativoRepository.save(tipoSistemaOperativo);
    }

    public void eliminarTipoSistemaOperativo(Long id){
        tipoSistemaOperativoRepository.delete(id);
    }
}
