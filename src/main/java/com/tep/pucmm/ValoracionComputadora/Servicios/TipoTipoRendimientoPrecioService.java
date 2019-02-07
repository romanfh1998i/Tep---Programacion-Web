package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.TipoTipoRendimientoPrecio;
import com.tep.pucmm.ValoracionComputadora.Repositorio.TipoTipoRendimientoPrecioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 18/10/18.
 */
@Service
@Transactional
public class TipoTipoRendimientoPrecioService {
    @Autowired
    private TipoTipoRendimientoPrecioRepository tipoTipoRendimientoPrecioRepository;

    public List<TipoTipoRendimientoPrecio> obtenerTipoTipoRendimientoPrecios(){
        return tipoTipoRendimientoPrecioRepository.findAll();
    }

    public TipoTipoRendimientoPrecio obtenerTipoTipoRendimientoPrecio(Long id){
        return tipoTipoRendimientoPrecioRepository.findOne(id);
    }


    public TipoTipoRendimientoPrecio guardarTipoTipoRendimientoPrecio(TipoTipoRendimientoPrecio tipoTipoRendimientoPrecio){
        return tipoTipoRendimientoPrecioRepository.save(tipoTipoRendimientoPrecio);
    }

    public void eliminarTipoTipoRendimientoPrecio(Long id){
        tipoTipoRendimientoPrecioRepository.delete(id);
    }
}
