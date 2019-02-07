package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.Bateria;
import com.tep.pucmm.ValoracionComputadora.Entidades.DiscoDuro;
import com.tep.pucmm.ValoracionComputadora.Repositorio.DiscoDuroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 17/10/18.
 */
@Service
@Transactional
public class DiscoDuroService {
    @Autowired
    private DiscoDuroRepository discoDuroRepository;

    public List<DiscoDuro> obtenerDiscoDuros(){
        return discoDuroRepository.findAll();
    }

    public DiscoDuro obtenerDiscoDuro(Long id){
        return discoDuroRepository.findOne(id);
    }

    public List<DiscoDuro> obtenerDiscoDuroByParte(Long id){
        return discoDuroRepository.findAllByParteId(id);
    }

    public DiscoDuro guardarDiscoDuro(DiscoDuro discoDuro){
        return discoDuroRepository.save(discoDuro);
    }

    public void eliminarDiscoDuro(Long id){
        discoDuroRepository.delete(id);
    }

    public void eliminarDiscoDuroPorParte(Long id){
        discoDuroRepository.deleteByParteId(id);
    }
}
