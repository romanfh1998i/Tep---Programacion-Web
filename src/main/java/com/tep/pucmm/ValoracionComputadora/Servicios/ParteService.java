package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.Gpu;
import com.tep.pucmm.ValoracionComputadora.Entidades.Parte;
import com.tep.pucmm.ValoracionComputadora.Repositorio.ParteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 18/10/18.
 */
@Service
@Transactional
public class ParteService {
    @Autowired
    private ParteRepository parteRepository;

    @Autowired
    private BateriaServices bateriaServices;

    @Autowired
    private CpuService cpuService;

    @Autowired
    private DiscoDuroService discoDuroService;

    @Autowired
    private GpuService gpuService;

    @Autowired
    private MemoriaService memoriaService;

    @Autowired
    private PuertoService puertoService;

    @Autowired
    private  TecladoService tecladoService;

    public List<Parte> obtenerPartes(){
        return parteRepository.findAll();
    }
    public List<Parte> obtenerPartesByComputadora(Long id){
        return parteRepository.findAllByComputadoraId(id);
    }

    public Parte obtenerParte(Long id){
        return parteRepository.findOne(id);
    }


    public Parte guardarParte(Parte parte){
        return parteRepository.save(parte);
    }

    public void eliminarParte(Long id){
        tecladoService.eliminarTecladoPorParte(id);
        bateriaServices.eliminarBateria(id);
        cpuService.eliminarCpuPorParte(id);
        discoDuroService.eliminarDiscoDuroPorParte(id);
        gpuService.eliminarGpuPorParte(id);
        memoriaService.eliminarMemoriaPorParte(id);
        puertoService.eliminarPuertoPorParte(id);
        parteRepository.delete(id);
    }

    public void eliminarPartePorComputadoraId(Long id){
        List<Parte> partes = parteRepository.findAllByComputadoraId(id);
        for(Parte parte: partes){
           eliminarParte(parte.getId());
        }
    }
}
