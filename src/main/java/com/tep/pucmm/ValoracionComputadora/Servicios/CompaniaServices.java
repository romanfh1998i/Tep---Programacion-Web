package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.Compania;
import com.tep.pucmm.ValoracionComputadora.Repositorio.CompaniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 17/10/18.
 */
@Transactional
@Service
public class CompaniaServices {
    @Autowired
    private CompaniaRepository companiaRepository;

    public List<Compania> obtenerCompanias(){
        return companiaRepository.findAll();
    }

    public Compania obtenerCompania(Long id){
        return companiaRepository.findOne(id);
    }


    public Compania guardarCompania(Compania compania){
        return companiaRepository.save(compania);
    }

    public void eliminarCompania(Long id){
        companiaRepository.delete(id);
    }
}
