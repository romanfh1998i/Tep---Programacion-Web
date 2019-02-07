package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.TipoPuerto;
import com.tep.pucmm.ValoracionComputadora.Repositorio.TipoPuertoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 18/10/18.
 */
@Service
@Transactional
public class TipoPuertoService {
    @Autowired
    private TipoPuertoRepository tipoPuertoRepository;

    public List<TipoPuerto> obtenerTipoPuertos(){
        return tipoPuertoRepository.findAll();
    }

    public TipoPuerto obtenerTipoPuerto(Long id){
        return tipoPuertoRepository.findOne(id);
    }


    public TipoPuerto guardarTipoPuerto(TipoPuerto tipoPuerto){
        return tipoPuertoRepository.save(tipoPuerto);
    }

    public void eliminarTipoPuerto(Long id){
        tipoPuertoRepository.delete(id);
    }
}
