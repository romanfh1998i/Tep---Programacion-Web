package com.tep.pucmm.ValoracionComputadora.Helpers;

import com.tep.pucmm.ValoracionComputadora.Servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Roman on 25/11/18.
 */
@Component
public class ValorHelper {
    @Autowired
    private ComputadoraService computadoraService;
    @Autowired
    private ParteService parteService;
    @Autowired
    private BateriaServices bateriaServices;
    @Autowired
    private CpuService cpuService;
    @Autowired
    private GpuService gpuService;
    @Autowired
    private PuertoService puertoService;
    @Autowired
    private TecladoService tecladoService;
    @Autowired
    private MemoriaService memoriaService;
    @Autowired
    private DiscoDuroService discoDuroService;

//    private float valorBateria(){
//        float score;
//    }


}
