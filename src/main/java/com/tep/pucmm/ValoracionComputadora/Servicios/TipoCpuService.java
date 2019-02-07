package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.TipoCPU;
import com.tep.pucmm.ValoracionComputadora.Repositorio.TipoCpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 18/10/18.
 */
@Service
@Transactional
public class TipoCpuService {
    @Autowired
    private TipoCpuRepository tipoCPURepository;

    public List<TipoCPU> obtenerTipoCpus(){
        return tipoCPURepository.findAll();
    }

    public TipoCPU obtenerTipoCpu(Long id){
        return tipoCPURepository.findOne(id);
    }


    public TipoCPU guardarTipoCpu(TipoCPU tipoCPU){
        return tipoCPURepository.save(tipoCPU);
    }

    public void eliminarTipoCpu(Long id){
        tipoCPURepository.delete(id);
    }
}
