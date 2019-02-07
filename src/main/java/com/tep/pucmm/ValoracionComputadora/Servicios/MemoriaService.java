package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.Bateria;
import com.tep.pucmm.ValoracionComputadora.Entidades.Memoria;
import com.tep.pucmm.ValoracionComputadora.Repositorio.MemoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 18/10/18.
 */
@Service
@Transactional
public class MemoriaService {
    @Autowired
    private MemoriaRepository memoriaRepository;

    public List<Memoria> obtenerMemorias(){
        return memoriaRepository.findAll();
    }

    public Memoria obtenerMemoria(Long id){
        return memoriaRepository.findOne(id);
    }

    public List<Memoria> obtenerMemoriaByParte(Long id){
        return memoriaRepository.findAllByParteId(id);
    }

    public Memoria guardarMemoria(Memoria memoria){
        return memoriaRepository.save(memoria);
    }

    public void eliminarMemoria(Long id){
        memoriaRepository.delete(id);
    }

    public void eliminarMemoriaPorParte(Long id){
        memoriaRepository.deleteByParteId(id);
    }
}
