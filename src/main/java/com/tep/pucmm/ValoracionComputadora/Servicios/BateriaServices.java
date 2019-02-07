package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.Bateria;
import com.tep.pucmm.ValoracionComputadora.Entidades.Puerto;
import com.tep.pucmm.ValoracionComputadora.Repositorio.BateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 17/10/18.
 */
@Service
@Transactional
public class BateriaServices {
    @Autowired
    private BateriaRepository bateriaRepository;

    public List<Bateria> obtenerBaterias(){
        return bateriaRepository.findAll();
    }

    public Bateria obtenerBateria(Long id){
        return bateriaRepository.findOne(id);
    }

    public List<Bateria> obtenerBarteriaByParte(Long id){
        return bateriaRepository.findAllByParteId(id);
    }

    public Bateria guardarBateria(Bateria bateria){
        return bateriaRepository.save(bateria);
    }


    public void eliminarBateria(Long id){
        bateriaRepository.delete(id);
    }

    public void eliminarBateriaPorParte(Long id){
        bateriaRepository.deleteByParteId(id);
    }

}
