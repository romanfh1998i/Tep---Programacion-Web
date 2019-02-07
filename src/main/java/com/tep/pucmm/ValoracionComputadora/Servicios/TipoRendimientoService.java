package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.TipoRendimiento;
import com.tep.pucmm.ValoracionComputadora.Repositorio.TipoRendimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 18/10/18.
 */
@Service
@Transactional
public class TipoRendimientoService {
    @Autowired
    private TipoRendimientoRepository tipoRendimientoRepository;

    public List<TipoRendimiento> obtenerTipoRendimientos(){
        return tipoRendimientoRepository.findAll();
    }

    public TipoRendimiento obtenerTipoRendimiento(Long id){
        return tipoRendimientoRepository.findOne(id);
    }


    public TipoRendimiento guardarTipoRendimiento(TipoRendimiento tipoRendimiento){
        return tipoRendimientoRepository.save(tipoRendimiento);
    }

    public void eliminarTipoRendimiento(Long id){
        tipoRendimientoRepository.delete(id);
    }
}
