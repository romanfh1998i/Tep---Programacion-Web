package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.Puerto;
import com.tep.pucmm.ValoracionComputadora.Repositorio.PuertoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 18/10/18.
 */
@Service
@Transactional
public class PuertoService {
    @Autowired
    private PuertoRepository puertoRepository;

    public List<Puerto> obtenerPuertos(){
        return puertoRepository.findAll();
    }

    public List<Puerto> obtenerPuertosByParte(Long id){
        return puertoRepository.findAllByParteId(id);
    }

    public Puerto obtenerPuerto(Long id){
        return puertoRepository.findOne(id);
    }


    public Puerto guardarPuerto(Puerto puerto){
        return puertoRepository.save(puerto);
    }

    public void eliminarPuerto(Long id){
        puertoRepository.delete(id);
    }

    public void eliminarPuertoPorParte(Long id){
        puertoRepository.deleteByParteId(id);
    }
}
