package com.tep.pucmm.ValoracionComputadora.Helpers;

import com.tep.pucmm.ValoracionComputadora.Entidades.CPU;
import com.tep.pucmm.ValoracionComputadora.Entidades.Gpu;
import com.tep.pucmm.ValoracionComputadora.Entidades.Parte;
import com.tep.pucmm.ValoracionComputadora.Entidades.Puerto;
import com.tep.pucmm.ValoracionComputadora.Servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.swing.CachedPainter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Roman on 03/11/18.
 */
@Component
public class EntityHelper {
    @Autowired
    private TipoComputadoraService tipoComputadoraService;
    @Autowired
    private TipoGpuService tipoGpuService;
    @Autowired
    private TipoDiscoDuroService tipoDiscoDuroService;
    @Autowired
    private TipoCpuService tipoCpuService;
    @Autowired
    private TipoConsumoEnergiaService tipoConsumoEnergiaService;
    @Autowired
    private TipoCapacidadService tipoCapacidadService;
    @Autowired
    private CompaniaServices companiaServices;
    @Autowired
    private TipoMaterialService tipoMaterialService;
    @Autowired
    private TipoMemoriaService tipoMemoriaService;
    @Autowired
    private TipoPuertoService tipoPuertoService;
    @Autowired
    private TipoRefrescanteService tipoRefrescanteService;
    @Autowired
    private TipoRendimientoService tipoRendimientoService;
    @Autowired
    private TipoSistemaOperativoService tipoSistemaOperativoService;
    @Autowired
    private TipoTecladoService tipoTecladoService;
    @Autowired
    private EstadoService estadoService;
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

    public Map<String, Object> getEntity(String tablename){
        Map<String, Object> entities = new HashMap<>();
            if (tablename.equals("tipoGpu") || tablename.equals("tipoCpu")){
                entities.put("companias",companiaServices.obtenerCompanias());
                return entities ;
            }

            if(tablename.equals("computadora")){
                entities.put("tipoSistemaOperativos",tipoSistemaOperativoService.obtenerTipoSistemaOperativos());
                entities.put("tipoComputadoras",tipoComputadoraService.obtenerTipoComputadoras());
                entities.put("tipoMateriales",tipoMaterialService.obtenerTipoMaterials());
                entities.put("estados", estadoService.obtenerEstados());
                return entities ;
            }

            if (tablename.equals("cpu")){
                entities.put("tipoConsumoEnergias", tipoConsumoEnergiaService.obtenerTipoConsumoEnergias());
                entities.put("tipoRefrescantes", tipoRefrescanteService.obtenerTipoRefrescantes());
                entities.put("tipoRendimientos", tipoRendimientoService.obtenerTipoRendimientos());
                entities.put("tipoCpus", tipoCpuService.obtenerTipoCpus());
            }

            if(tablename.equals("discoDuro")){
                entities.put("tipoCapacidades", tipoCapacidadService.obtenerTipoCapacidads());
                entities.put("tipoDiscoDuros", tipoDiscoDuroService.obtenerTipoDiscoDuros());
            }

            if(tablename.equals("gpu")){
                entities.put("tipoCapacidades", tipoCapacidadService.obtenerTipoCapacidads());
                entities.put("tipoGpus", tipoGpuService.obtenerTipoGpus());
            }

            if(tablename.equals("memoria")){
                entities.put("tipoCapacidades", tipoCapacidadService.obtenerTipoCapacidads());
                entities.put("tipoMemorias", tipoMemoriaService.obtenerTipoMemorias());
            }

            if(tablename.equals("puerto")){
                entities.put("tipoPuertos", tipoPuertoService.obtenerTipoPuertos());
            }

            if(tablename.equals("teclado")){
                entities.put("tipoTeclados", tipoTecladoService.obtenerTipoTeclados());
            }

            if(tablename.equals("parte")){
                entities.put("computadoras", estadoService.obtenerEstados());
            }

        return entities;
    }

    public Map<String, Object> getEntityByObject(List<Parte> objetos){
        Map<String, Object> entities = new HashMap<>();
        for (Parte parte: objetos){


            if(parte.getNombre().equals("Bateria"))
                entities.put("baterias", bateriaServices.obtenerBarteriaByParte(parte.getId()));

            if(parte.getNombre().equals("Disco Duro"))
                entities.put("discoDuros", discoDuroService.obtenerDiscoDuroByParte(parte.getId()));

            if(parte.getNombre().equals("CPU"))
                entities.put("cpus", cpuService.obtenerCpuByParte(parte.getId()));

            if(parte.getNombre().equals("GPU"))
                entities.put("gpus", gpuService.obtenerGpuByParte(parte.getId()));

            if(parte.getNombre().equals("Memoria"))
                entities.put("memorias", memoriaService.obtenerMemoriaByParte(parte.getId()));

            if(parte.getNombre().equals("Puerto"))
                entities.put("puertos", puertoService.obtenerPuertosByParte(parte.getId()));

            if(parte.getNombre().equals("Teclado"))
                entities.put("teclados", tecladoService.obtenerTecladoByParte(parte.getId()));

        }
        return entities;
    }

    public  boolean esParte (String tableName){
        return tableName.equals("bateria") ||
                tableName.equals("cpu") ||
                tableName.equals("discoDuro") ||
                tableName.equals("gpu") ||
                tableName.equals("memoria") ||
                tableName.equals("puerto") ||
                tableName.equals("teclado");
    }
}
