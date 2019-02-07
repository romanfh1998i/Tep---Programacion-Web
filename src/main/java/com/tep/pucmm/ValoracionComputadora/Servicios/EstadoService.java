package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.Estado;
import com.tep.pucmm.ValoracionComputadora.Repositorio.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 09/11/18.
 */
@Service
@Transactional
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> obtenerEstados(){
        return estadoRepository.findAll();
    }

    public Estado obtenerEstado(Long id){
        return estadoRepository.findOne(id);
    }


    public Estado guardarEstado(Estado estado){
        return estadoRepository.save(estado);
    }

    public void eliminarEstado(Long id){
        estadoRepository.delete(id);
    }
}
