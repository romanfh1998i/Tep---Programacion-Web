package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.Bateria;
import com.tep.pucmm.ValoracionComputadora.Entidades.CPU;
import com.tep.pucmm.ValoracionComputadora.Repositorio.CpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 17/10/18.
 */
@Service
@Transactional
public class CpuService {

    @Autowired
    private CpuRepository cpuRepository;

    public List<CPU> obtenerCpus(){
        return cpuRepository.findAll();
    }

    public List<CPU> obtenerCpuByParte(Long id){
        return cpuRepository.findAllByParteId(id);
    }

    public CPU obtenerCpu(Long id){
        return cpuRepository.findOne(id);
    }


    public CPU guardarCpu(CPU cpu){
        return cpuRepository.save(cpu);
    }

    public void eliminarCpu(Long id){
        cpuRepository.delete(id);
    }

    public void eliminarCpuPorParte(Long id){
        cpuRepository.deleteByParteId(id);
    }
}
