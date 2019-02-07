package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.Bateria;
import com.tep.pucmm.ValoracionComputadora.Entidades.Gpu;
import com.tep.pucmm.ValoracionComputadora.Repositorio.GpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 17/10/18.
 */
@Service
@Transactional
public class GpuService {
    @Autowired
    private GpuRepository gpuRepository;

    public List<Gpu> obtenerGpus(){
        return gpuRepository.findAll();
    }

    public Gpu obtenerGpu(Long id){
        return gpuRepository.findOne(id);
    }

    public List<Gpu> obtenerGpuByParte(Long id){
        return gpuRepository.findAllByParteId(id);
    }

    public Gpu guardarGpu(Gpu gpu){
        return gpuRepository.save(gpu);
    }

    public void eliminarGpu(Long id){
        gpuRepository.delete(id);
    }

    public void eliminarGpuPorParte(Long id){
        gpuRepository.deleteByParteId(id);
    }
}
