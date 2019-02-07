package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.TipoGPU;
import com.tep.pucmm.ValoracionComputadora.Repositorio.TipoGpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 18/10/18.
 */
@Service
@Transactional
public class TipoGpuService {
    @Autowired
    private TipoGpuRepository tipoGPURepository;

    public List<TipoGPU> obtenerTipoGpus(){
        return tipoGPURepository.findAll();
    }

    public TipoGPU obtenerTipoGpu(Long id){
        return tipoGPURepository.findOne(id);
    }


    public TipoGPU guardarTipoGpu(TipoGPU tipoGPU){
        return tipoGPURepository.save(tipoGPU);
    }

    public void eliminarTipoGpu(Long id){
        tipoGPURepository.delete(id);
    }
}
