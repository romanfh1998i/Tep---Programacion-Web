package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.Valor;
import com.tep.pucmm.ValoracionComputadora.Repositorio.ValorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 25/11/18.
 */
@Service
@Transactional
public class ValorService {
    @Autowired
    private ValorRepository valorRepository;

    public List<Valor> obtenerValors(){
        return valorRepository.findAll();
    }

    public Valor obtenerValor(Long id){
        return valorRepository.findOne(id);
    }


    public Valor guardarValor(Valor valor){
        return valorRepository.save(valor);
    }

    public void eliminarValor(Long id){
        valorRepository.delete(id);
    }
}
