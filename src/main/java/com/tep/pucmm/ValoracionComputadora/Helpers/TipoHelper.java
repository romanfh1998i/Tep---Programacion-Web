package com.tep.pucmm.ValoracionComputadora.Helpers;

import com.tep.pucmm.ValoracionComputadora.Entidades.*;
import com.tep.pucmm.ValoracionComputadora.Servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by Roman on 27/10/18.
 */
@Component
public class TipoHelper {
    @Autowired
    private ComputadoraService computadoraService;
    @Autowired
    private ParteService parteService;
    @Autowired
    private EstadoService estadoService;
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
    private TipoTipoRendimientoPrecioService tipoTipoRendimientoPrecioService;
    @Autowired
    private UsuarioService usuarioService;
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
    private TecladoService tecladoService;
    

    public TipoHelper() {

    }

    public TipoObject getHelperObject(String action, String tablename, Long id) {
        TipoObject tipoObject = new TipoObject();
        if (action.equals("crear")) {
            switch (tablename) {
                case "computadora":
                    tipoObject.setActionName("/crear/crear-computadora");
                    Computadora computadora = new Computadora();
                    computadora.setTipoComputadora(new TipoComputadora());
                    computadora.setTipoMaterial(new TipoMaterial());
                    computadora.setTipoSistemaOperativo(new TipoSistemaOperativo());
                    computadora.setEstado(new Estado());
                    tipoObject.setObjeto(computadora);
                    return tipoObject;
                case "parte":
                    tipoObject.setActionName("/crear/crear-parte");
                    Parte parte = new Parte();
                    parte.setComputadora(computadoraService.obtenerComputadora(id));
                    tipoObject.setObjeto(parte);
                    return tipoObject;
                case "bateria":
                    tipoObject.setActionName("/crear/crear-bateria");
                    Bateria bateria = new Bateria();
                    bateria.setParte(parteService.obtenerParte(id));
                    tipoObject.setObjeto(bateria);
                    return tipoObject;
                case "cpu":
                    tipoObject.setActionName("/crear/crear-cpu");
                    CPU cpu = new CPU();
                    cpu.setParte(parteService.obtenerParte(id));
                    cpu.setTipoConsumoEnergia(new TipoConsumoEnergia());
                    cpu.setTipoCPU(new TipoCPU());
                    cpu.setTipoRefrescante(new TipoRefrescante());
                    cpu.setTipoRendimiento(new TipoRendimiento());
                    tipoObject.setObjeto(cpu);
                    return tipoObject;
                case "discoDuro":
                    tipoObject.setActionName("/crear/crear-discoDuro");
                    DiscoDuro discoDuro = new DiscoDuro();
                    discoDuro.setParte(parteService.obtenerParte(id));
                    discoDuro.setTipoCapacidad(new TipoCapacidad());
                    discoDuro.setTipoDiscoDuro(new TipoDiscoDuro());
                    tipoObject.setObjeto(discoDuro);
                    return tipoObject;
                case "gpu":
                    tipoObject.setActionName("/crear/crear-gpu");
                    Gpu gpu = new Gpu();
                    gpu.setParte(parteService.obtenerParte(id));
                    gpu.setTipoCapacidad(new TipoCapacidad());
                    gpu.setTipoGPU(new TipoGPU());
                    tipoObject.setObjeto(gpu);
                    return tipoObject;
                case "memoria":
                    tipoObject.setActionName("/crear/crear-memoria");
                    Memoria memoria = new Memoria();
                    memoria.setParte(parteService.obtenerParte(id));
                    memoria.setTipoMemoria(new TipoMemoria());
                    memoria.setTipoCapacidad(new TipoCapacidad());
                    tipoObject.setObjeto(memoria);
                    return tipoObject;
                case "puerto":
                    tipoObject.setActionName("/crear/crear-puerto");
                    Puerto puerto = new Puerto();
                    puerto.setParte(parteService.obtenerParte(id));
                    puerto.setTipoPuerto(new TipoPuerto());
                    tipoObject.setObjeto(puerto);
                    return tipoObject;
                case "teclado":
                    tipoObject.setActionName("/crear/crear-teclado");
                    Teclado teclado =  new Teclado();
                    teclado.setParte(parteService.obtenerParte(id));
                    teclado.setTipoTeclado(new TipoTeclado());
                    tipoObject.setObjeto(teclado);
                    return tipoObject;
                case "tipoComputadora":
                    tipoObject.setActionName("/crear/crear-tipo-computadora");
                    tipoObject.setObjeto(new TipoComputadora());
                    return tipoObject;
                case "estado":
                    tipoObject.setActionName("/crear/crear-estado");
                    tipoObject.setObjeto(new Estado());
                    return tipoObject;
                case "tipoGpu":
                    tipoObject.setActionName("/crear/crear-tipo-gpu");
                    TipoGPU tipoGPU = new TipoGPU();
                    tipoGPU.setCompania(new Compania());
                    tipoObject.setObjeto(tipoGPU);
                    return tipoObject;
                case "tipoDiscoDuro":
                    tipoObject.setActionName("/crear/crear-tipo-discoDuro");
                    tipoObject.setObjeto(new TipoDiscoDuro());
                    return tipoObject;
                case "tipoCpu":
                    tipoObject.setActionName("/crear/crear-tipo-cpu");
                    TipoCPU tipoCPU = new TipoCPU();
                    tipoCPU.setCompania(new Compania());
                    tipoObject.setObjeto(tipoCPU);
                    return tipoObject;
                case "tipoConsumoEnergia":
                    tipoObject.setActionName("/crear/crear-tipo-consumoEnergia");
                    tipoObject.setObjeto(new TipoConsumoEnergia());
                    return tipoObject;
                case "tipoCapacidad":
                    tipoObject.setActionName("/crear/crear-tipo-capacidad");
                    tipoObject.setObjeto(new TipoCapacidad());
                    return tipoObject;
                case "tipoCompania":
                    tipoObject.setActionName("/crear/crear-compania");
                    tipoObject.setObjeto(new Compania());
                    return tipoObject;
                case "tipoMaterial":
                    tipoObject.setActionName("/crear/crear-tipo-material");
                    tipoObject.setObjeto(new TipoMaterial());
                    return tipoObject;
                case "tipoMemoria":
                    tipoObject.setActionName("/crear/crear-tipo-memoria");
                    tipoObject.setObjeto(new TipoMemoria());
                    return tipoObject;
                case "tipoPuerto":
                    tipoObject.setActionName("/crear/crear-tipo-puerto");
                    tipoObject.setObjeto(new TipoPuerto());
                    return tipoObject;
                case "tipoRefrescante":
                    tipoObject.setActionName("/crear/crear-tipo-refrescante");
                    tipoObject.setObjeto(new TipoRefrescante());
                    return tipoObject;
                case "tipoRendimiento":
                    tipoObject.setActionName("/crear/crear-tipo-rendimiento");
                    tipoObject.setObjeto(new TipoRendimiento());
                    return tipoObject;
                case "tipoSistemaOperativo":
                    tipoObject.setActionName("/crear/crear-tipo-sistema-operativo");
                    tipoObject.setObjeto(new TipoSistemaOperativo());
                    return tipoObject;
                case "tipoTeclado":
                    tipoObject.setActionName("/crear/crear-tipo-teclado");
                    tipoObject.setObjeto(new TipoTeclado());
                    return tipoObject;
                case "tipoTipoRendimientoPrecio":
                    tipoObject.setActionName("/crear/crear-tipo-tipo-tipo-rendimiento-precio");
                    tipoObject.setObjeto(new TipoTipoRendimientoPrecio());
                    return tipoObject;
                default:
                    tipoObject.setActionName("404");
                    return tipoObject;
            }
        } else if (action.equals("ver")) {
            switch (tablename) {
                case "computadora":
                    tipoObject.setActionName("/ver/ver-computadora");
                    tipoObject.setObjeto(computadoraService.obtenerComputadorasPorUsuario(id));
                    return tipoObject;
                case "parte":
                    tipoObject.setActionName("/ver/ver-parte");
                    tipoObject.setObjeto(parteService.obtenerPartesByComputadora(id));
                    return tipoObject;
                case "bateria":
                    tipoObject.setActionName("/ver/ver-parte");
                    tipoObject.setObjeto(bateriaServices.obtenerBarteriaByParte(id));
                    return tipoObject;
                case "cpu":
                    tipoObject.setActionName("/ver/ver-parte");
                    tipoObject.setObjeto(cpuService.obtenerCpuByParte(id));
                    return tipoObject;
                case "discoDuro":
                    tipoObject.setActionName("/ver/ver-parte");
                    tipoObject.setObjeto(discoDuroService.obtenerDiscoDuroByParte(id));
                    return tipoObject;
                case "gpu":
                    tipoObject.setActionName("/ver/ver-parte");
                    tipoObject.setObjeto(discoDuroService.obtenerDiscoDuroByParte(id));
                    return tipoObject;
                case "memoria":
                    tipoObject.setActionName("/ver/ver-parte");
                    tipoObject.setObjeto(memoriaService.obtenerMemoriaByParte(id));
                    return tipoObject;
                case "puerto":
                    tipoObject.setActionName("/ver/ver-parte");
                    tipoObject.setObjeto(puertoService.obtenerPuertosByParte(id));
                    return tipoObject;
                case "teclado":
                    tipoObject.setActionName("/ver/ver-parte");
                    tipoObject.setObjeto(puertoService.obtenerPuertosByParte(id));
                    return tipoObject;
                case "tipoComputadora":
                    tipoObject.setActionName("/ver/ver-tipo-computadora");
                    tipoObject.setObjeto(tipoComputadoraService.obtenerTipoComputadoras());
                    return tipoObject;
                case "tipoGpu":
                    tipoObject.setActionName("/ver/ver-tipo-gpu");
                    tipoObject.setObjeto(tipoGpuService.obtenerTipoGpus());
                    return tipoObject;
                case "estado":
                    tipoObject.setActionName("/ver/ver-estado");
                    tipoObject.setObjeto(estadoService.obtenerEstados());
                    return tipoObject;
                case "tipoDiscoDuro":
                    tipoObject.setActionName("/ver/ver-tipo-discoDuro");
                    tipoObject.setObjeto(tipoDiscoDuroService.obtenerTipoDiscoDuros());
                    return tipoObject;
                case "tipoCpu":
                    tipoObject.setActionName("/ver/ver-tipo-cpu");
                    tipoObject.setObjeto(tipoCpuService.obtenerTipoCpus());
                    return tipoObject;
                case "tipoConsumoEnergia":
                    tipoObject.setActionName("/ver/ver-tipo-consumoEnergia");
                    tipoObject.setObjeto(tipoConsumoEnergiaService.obtenerTipoConsumoEnergias());
                    return tipoObject;
                case "tipoCapacidad":
                    tipoObject.setActionName("/ver/ver-tipo-capacidad");
                    tipoObject.setObjeto(tipoCapacidadService.obtenerTipoCapacidads());
                    return tipoObject;
                case "tipoCompania":
                    tipoObject.setObjeto(companiaServices.obtenerCompanias());
                    tipoObject.setActionName("/ver/ver-compania");
                    return tipoObject;
                case "tipoMaterial":
                    tipoObject.setActionName("/ver/ver-tipo-material");
                    tipoObject.setObjeto(tipoMaterialService.obtenerTipoMaterials());
                    return tipoObject;
                case "tipoMemoria":
                    tipoObject.setActionName("/ver/ver-tipo-memoria");
                    tipoObject.setObjeto(tipoMemoriaService.obtenerTipoMemorias());
                    return tipoObject;
                case "tipoPuerto":
                    tipoObject.setActionName("/ver/ver-tipo-puerto");
                    tipoObject.setObjeto(tipoPuertoService.obtenerTipoPuertos());
                    return tipoObject;
                case "tipoRefrescante":
                    tipoObject.setActionName("/ver/ver-tipo-refrescante");
                    tipoObject.setObjeto(tipoRefrescanteService.obtenerTipoRefrescantes());
                    return tipoObject;
                case "tipoRendimiento":
                    tipoObject.setActionName("/ver/ver-tipo-rendimiento");
                    tipoObject.setObjeto(tipoRendimientoService.obtenerTipoRendimientos());
                    return tipoObject;
                case "tipoSistemaOperativo":
                    tipoObject.setActionName("/ver/ver-tipo-sistema-operativo");
                    tipoObject.setObjeto(tipoSistemaOperativoService.obtenerTipoSistemaOperativos());
                    return tipoObject;
                case "tipoTeclado":
                    tipoObject.setActionName("/ver/ver-tipo-teclado");
                    tipoObject.setObjeto(tipoTecladoService.obtenerTipoTeclados());
                    return tipoObject;
                case "tipoTipoRendimientoPrecio":
                    tipoObject.setActionName("/ver/ver-tipo-tipo-tipo-rendimiento-precio");
                    tipoObject.setObjeto(tipoTipoRendimientoPrecioService.obtenerTipoTipoRendimientoPrecios());
                    return tipoObject;
                default:
                    tipoObject.setActionName("404");
                    return tipoObject;
            }

        } else if (action.equals("actualizar")) {
            switch (tablename) {
                case "computadora":
                    tipoObject.setActionName("/actualizar/actualizar-computadora");
                    tipoObject.setObjeto(computadoraService.obtenerComputadora(id));
                    return tipoObject;
                case "parte":
                    tipoObject.setActionName("/actualizar/actualizar-parte");
                    tipoObject.setObjeto(parteService.obtenerParte(id));
                    return tipoObject;
                case "bateria":
                    tipoObject.setActionName("/actualizar/actualizar-bateria");
                    tipoObject.setObjeto(bateriaServices.obtenerBateria(id));
                    return tipoObject;
                case "cpu":
                    tipoObject.setActionName("/actualizar/actualizar-cpu");
                    tipoObject.setObjeto(cpuService.obtenerCpu(id));
                    return tipoObject;
                case "discoDuro":
                    tipoObject.setActionName("/actualizar/actualizar-discoDuro");
                    tipoObject.setObjeto(discoDuroService.obtenerDiscoDuro(id));
                    return tipoObject;
                case "gpu":
                    tipoObject.setActionName("/actualizar/actualizar-gpu");
                    tipoObject.setObjeto(gpuService.obtenerGpu(id));
                    return tipoObject;
                case "memoria":
                    tipoObject.setActionName("/actualizar/actualizar-memoria");
                    tipoObject.setObjeto(memoriaService.obtenerMemoria(id));
                    return tipoObject;
                case "puerto":
                    tipoObject.setActionName("/actualizar/actualizar-puerto");
                    tipoObject.setObjeto(puertoService.obtenerPuerto(id));
                    return tipoObject;
                case "teclado":
                    tipoObject.setActionName("/actualizar/actualizar-teclado");
                    tipoObject.setObjeto(tecladoService.obtenerTeclado(id));
                    return tipoObject;
                case "tipoComputadora":
                    tipoObject.setActionName("/actualizar/actualizar-tipo-computadora");
                    tipoObject.setObjeto(tipoComputadoraService.obtenerTipoComputadora(id));
                    return tipoObject;
                case "tipoGpu":
                    tipoObject.setActionName("/actualizar/actualizar-tipo-gpu");
                    tipoObject.setObjeto(tipoGpuService.obtenerTipoGpu(id));
                    return tipoObject;
                case "estado":
                    tipoObject.setActionName("/actualizar/actualizar-estado");
                    tipoObject.setObjeto(estadoService.obtenerEstado(id));
                    return tipoObject;
                case "tipoDiscoDuro":
                    tipoObject.setActionName("/actualizar/actualizar-tipo-discoDuro");
                    tipoObject.setObjeto(tipoDiscoDuroService.obtenerTipoDiscoDuro(id));
                    return tipoObject;
                case "tipoCpu":
                    tipoObject.setActionName("/actualizar/actualizar-tipo-cpu");
                    tipoObject.setObjeto(tipoCpuService.obtenerTipoCpu(id));
                    return tipoObject;
                case "tipoConsumoEnergia":
                    tipoObject.setActionName("/actualizar/actualizar-tipo-consumoEnergia");
                    tipoObject.setObjeto(tipoConsumoEnergiaService.obtenerTipoConsumoEnergia(id));
                    return tipoObject;
                case "tipoCapacidad":
                    tipoObject.setActionName("/actualizar/actualizar-tipo-capacidad");
                    tipoObject.setObjeto(tipoCapacidadService.obtenerTipoCapacidad(id));
                    return tipoObject;
                case "tipoCompania":
                    tipoObject.setObjeto(companiaServices.obtenerCompania(id));
                    tipoObject.setActionName("/actualizar/actualizar-compania");
                    return tipoObject;
                case "tipoMaterial":
                    tipoObject.setActionName("/actualizar/actualizar-tipo-material");
                    tipoObject.setObjeto(tipoMaterialService.obtenerTipoMaterial(id));
                    return tipoObject;
                case "tipoMemoria":
                    tipoObject.setActionName("/actualizar/actualizar-tipo-memoria");
                    tipoObject.setObjeto(tipoMemoriaService.obtenerTipoMemoria(id));
                    return tipoObject;
                case "tipoPuerto":
                    tipoObject.setActionName("/actualizar/actualizar-tipo-puerto");
                    tipoObject.setObjeto(tipoPuertoService.obtenerTipoPuerto(id));
                    return tipoObject;
                case "tipoRefrescante":
                    tipoObject.setActionName("/actualizar/actualizar-tipo-refrescante");
                    tipoObject.setObjeto(tipoRefrescanteService.obtenerTipoRefrescante(id));
                    return tipoObject;
                case "tipoRendimiento":
                    tipoObject.setActionName("/actualizar/actualizar-tipo-rendimiento");
                    tipoObject.setObjeto(tipoRendimientoService.obtenerTipoRendimiento(id));
                    return tipoObject;
                case "tipoSistemaOperativo":
                    tipoObject.setActionName("/actualizar/actualizar-tipo-sistema-operativo");
                    tipoObject.setObjeto(tipoSistemaOperativoService.obtenerTipoSistemaOperativo(id));
                    return tipoObject;
                case "tipoTeclado":
                    tipoObject.setActionName("/actualizar/actualizar-tipo-teclado");
                    tipoObject.setObjeto(tipoTecladoService.obtenerTipoTeclado(id));
                    return tipoObject;
                case "tipoTipoRendimientoPrecio":
                    tipoObject.setActionName("/actualizar/actualizar-tipo-tipo-tipo-rendimiento-precio");
                    tipoObject.setObjeto(tipoTipoRendimientoPrecioService.obtenerTipoTipoRendimientoPrecio(id));
                    return tipoObject;
                default:
                    tipoObject.setActionName("404");
                    return tipoObject;
            }
        }
        tipoObject.setActionName("404");
        return tipoObject;
    }

    public Object helperAddUpdate(Object object, Map<String, Object> entidades) {
        if (object instanceof Computadora) {
            Computadora computadora = Computadora.class.cast(object);
            Usuario usuario = usuarioService.buscarUsuarioPorUsername(entidades.get("usuario").toString());
            computadora.setUsuario(usuario.getId());
            return computadoraService.guardarComputadora(computadora);
        }
        else if (object instanceof TipoComputadora) {
            return tipoComputadoraService.guardarTipoComputadora(TipoComputadora.class.cast(object));
        }else if (object instanceof Parte) {
            return parteService.guardarParte(Parte.class.cast(object));
        } else if (object instanceof TipoGPU) {
            TipoGPU tipoGPU = TipoGPU.class.cast(object);
            tipoGPU.getCompania().setId(convertToLong(entidades.get("compania").toString()));
            return tipoGpuService.guardarTipoGpu(tipoGPU);
        } else if (object instanceof TipoDiscoDuro) {
            return tipoDiscoDuroService.guardarTipoDiscoDuro(TipoDiscoDuro.class.cast(object));
        } else if (object instanceof TipoCPU) {
            TipoCPU tipoCPU =  TipoCPU.class.cast(object);
            tipoCPU.getCompania().setId(convertToLong(entidades.get("compania").toString()));
            return tipoCpuService.guardarTipoCpu(tipoCPU);
        } else if (object instanceof TipoConsumoEnergia) {
            return tipoConsumoEnergiaService.guardarTipoConsumoEnergia(TipoConsumoEnergia.class.cast(object));
        } else if (object instanceof TipoCapacidad) {
            return tipoCapacidadService.guardarTipoCapacidad(TipoCapacidad.class.cast(object));
        } else if (object instanceof Estado) {
            return estadoService.guardarEstado(Estado.class.cast(object));
        } else if (object instanceof Compania) {
            return companiaServices.guardarCompania(Compania.class.cast(object));
        } else if (object instanceof TipoMaterial) {
            return tipoMaterialService.guardarTipoMaterial((TipoMaterial) object);
        } else if (object instanceof TipoMemoria) {
            return tipoMemoriaService.guardarTipoMemoria(TipoMemoria.class.cast(object));
        } else if (object instanceof TipoPuerto) {
            return tipoPuertoService.guardarTipoPuerto(TipoPuerto.class.cast(object));
        } else if (object instanceof TipoRefrescante) {
            return tipoRefrescanteService.guardarTipoRefrescante(TipoRefrescante.class.cast(object));
        } else if (object instanceof TipoRendimiento) {
            return tipoRendimientoService.guardarTipoRendimiento(TipoRendimiento.class.cast(object));
        } else if (object instanceof TipoSistemaOperativo) {
            return tipoSistemaOperativoService.guardarTipoSistemaOperativo(TipoSistemaOperativo.class.cast(object));
        } else if (object instanceof TipoTeclado) {
            return tipoTecladoService.guardarTipoTeclado(TipoTeclado.class.cast(object));
        } else if (object instanceof TipoTipoRendimientoPrecio) {
            return tipoTipoRendimientoPrecioService.guardarTipoTipoRendimientoPrecio(TipoTipoRendimientoPrecio.class.cast(object));
        } else if (object instanceof Bateria) {
            Bateria bateria = Bateria.class.cast(object);
            bateria.setParte(new Parte());
            bateria.getParte().setId(convertToLong(entidades.get("parte").toString()));
            return bateriaServices.guardarBateria(bateria);
        } else if (object instanceof CPU) {
            CPU cpu = CPU.class.cast(object);
            cpu.setParte(new Parte());
            cpu.getParte().setId(convertToLong(entidades.get("parte").toString()));
            cpu.getTipoCPU().setId(convertToLong(entidades.get("tipoCPU").toString()));
            cpu.getTipoRendimiento().setId(convertToLong(entidades.get("tipoRendimiento").toString()));
            cpu.getTipoRefrescante().setId(convertToLong(entidades.get("tipoRefrescante").toString()));
            cpu.getTipoConsumoEnergia().setId(convertToLong(entidades.get("tipoConsumoEnergia").toString()));
            return cpuService.guardarCpu(cpu);
        } else if (object instanceof Gpu) {
            Gpu gpu= Gpu.class.cast(object);
            gpu.setParte(new Parte());
            gpu.getParte().setId(convertToLong(entidades.get("parte").toString()));
            gpu.getTipoCapacidad().setId(convertToLong(entidades.get("tipoCapacidad").toString()));
            gpu.getTipoGPU().setId(convertToLong(entidades.get("tipoGpu").toString()));
            return gpuService.guardarGpu(gpu);
        } else if (object instanceof DiscoDuro) {
            DiscoDuro discoDuro= DiscoDuro.class.cast(object);
            discoDuro.setParte(new Parte());
            discoDuro.getTipoCapacidad().setId(convertToLong(entidades.get("tipoCapacidad").toString()));
            discoDuro.getTipoDiscoDuro().setId(convertToLong(entidades.get("tipoDiscoDuro").toString()));
            discoDuro.getParte().setId(convertToLong(entidades.get("parte").toString()));
            return discoDuroService.guardarDiscoDuro(discoDuro);
        } else if (object instanceof Memoria) {
            Memoria memoria = Memoria.class.cast(object);
            memoria.setParte(new Parte());
            memoria.getTipoCapacidad().setId(convertToLong(entidades.get("tipoCapacidad").toString()));
            memoria.getTipoMemoria().setId(convertToLong(entidades.get("tipoMemoria").toString()));
            memoria.getParte().setId(convertToLong(entidades.get("parte").toString()));
            return memoriaService.guardarMemoria(memoria);
        } else if (object instanceof Puerto) {
            Puerto puerto= Puerto.class.cast(object);
            puerto.setParte(new Parte());
            puerto.getTipoPuerto().setId(convertToLong(entidades.get("tipoPuerto").toString()));
            puerto.getParte().setId(convertToLong(entidades.get("parte").toString()));
            return puertoService.guardarPuerto(puerto);
        } else if (object instanceof Teclado) {
            Teclado teclado = Teclado.class.cast(object);
            teclado.setParte(new Parte());
            teclado.getTipoTeclado().setId(convertToLong(entidades.get("tipoTeclado").toString()));
            teclado.getParte().setId(convertToLong(entidades.get("parte").toString()));
            return tecladoService.guardarTeclado(teclado);
        }
        return null;
    }


    public String getHelperView(String action, String tablename) {
        if (action.equals("crear")) {
            switch (tablename) {
                case "computadora":
                    return "/crear/crear-computadora";
                case "parte":
                    return "/crear/crear-parte";
                case "bateria":
                    return "/crear/crear-bateria";
                case "cpu":
                    return "/crear/crear-cpu";
                case "discoDuro":
                    return "/crear/crear-discoDuro";
                case "gpu":
                    return "/crear/crear-gpu";
                case "memoria":
                    return "/crear/crear-memoria";
                case "puerto":
                    return "/crear/crear-puerto";
                case "teclado":
                    return "/crear/crear-teclado";
                case "tipoComputadora":
                    return "/crear/crear-tipo-computadora";
                case "tipoGpu":
                    return "/crear/crear-tipo-gpu";
                case "estado":
                    return "/crear/crear-estado";
                case "tipoDiscoDuro":
                    return "/crear/crear-tipo-discoDuro";
                case "tipoCpu":
                    return "/crear/crear-tipo-cpu";
                case "tipoConsumoEnergia":
                    return "/crear/crear-tipo-consumoEnergia";
                case "tipoCapacidad":
                    return "/crear/crear-tipo-capacidad";
                case "tipoCompania":
                    return "/crear/crear-compania";
                case "tipoMaterial":
                    return "/crear/crear-tipo-material";
                case "tipoMemoria":
                    return "/crear/crear-tipo-memoria";
                case "tipoPuerto":
                    return "/crear/crear-tipo-puerto";
                case "tipoRefrescante":
                    return "/crear/crear-tipo-refrescante";
                case "tipoRendimiento":
                    return "/crear/crear-tipo-rendimiento";
                case "tipoSistemaOperativo":
                    return "/crear/crear-tipo-sistema-operativo";
                case "tipoTeclado":
                    return "/crear/crear-tipo-teclado";
                case "tipoTipoRendimientoPrecio":
                    return "/crear/crear-tipo-tipo-tipo-rendimiento-precio";
                default:
                    return "404";
            }
        } else if (action.equals("ver")) {
            switch (tablename) {
                case "computadora":
                    return "/ver/ver-computadora";
                case "parte":
                    return "/ver/ver-parte";
                case "bateria":
                    return "/ver/ver-parte";
                case "cpu":
                    return "/ver/ver-parte";
                case "discoDuro":
                    return "/ver/ver-parte";
                case "gpu":
                    return "/ver/ver-parte";
                case "memoria":
                    return "/ver/ver-parte";
                case "puerto":
                    return "/ver/ver-parte";
                case "teclado":
                    return "/ver/ver-parte";
                case "tipoComputadora":
                    return "/ver/ver-tipo-computadora";
                case "tipoGpu":
                    return "/ver/ver-tipo-gpu";
                case "tipoDiscoDuro":
                    return "/ver/ver-tipo-discoDuro";
                case "tipoCpu":
                    return "/ver/ver-tipo-cpu";
                case "estado":
                    return "/ver/ver-estado";
                case "tipoConsumoEnergia":
                    return "/ver/ver-tipo-consumoEnergia";
                case "tipoCapacidad":
                    return "/ver/ver-tipo-capacidad";
                case "tipoCompania":
                    return "/ver/ver-compania";
                case "tipoMaterial":
                    return "/ver/ver-tipo-material";
                case "tipoMemoria":
                    return "/ver/ver-tipo-memoria";
                case "tipoPuerto":
                    return "/ver/ver-tipo-puerto";
                case "tipoRefrescante":
                    return "/ver/ver-tipo-refrescante";
                case "tipoRendimiento":
                    return "/ver/ver-tipo-rendimiento";
                case "tipoSistemaOperativo":
                    return "/ver/ver-tipo-sistema-operativo";
                case "tipoTeclado":
                    return "/ver/ver-tipo-teclado";
                case "tipoTipoRendimientoPrecio":
                    return "/ver/ver-tipo-tipo-tipo-rendimiento-precio";
                default:
                    return "404";
            }

        } else if (action.equals("actualizar")) {
            switch (tablename) {
                case "tipoComputadora":
                    return "/actualizar/actualizar-tipo-computadora";
                case "computadora":
                    return "/actualizar/actualizar-computadora";
                case "parte":
                    return "/actualizar/actualizar-parte";
                case "bateria":
                    return "/actualizar/actualizar-bateria";
                case "cpu":
                    return "/actualizar/actualizar-cpu";
                case "discoDuro":
                    return "/actualizar/actualizar-discoDuro";
                case "gpu":
                    return "/actualizar/actualizar-gpu";
                case "memoria":
                    return "/actualizar/actualizar-memoria";
                case "puerto":
                    return "/actualizar/actualizar-puerto";
                case "teclado":
                    return "/actualizar/actualizar-teclado";
                case "tipogpu":
                    return "/actualizar/actualizar-tipo-gpu";
                case "tipoDiscoDuro":
                    return "/actualizar/actualizar-tipo-discoDuro";
                case "tipoCpu":
                    return "/actualizar/actualizar-tipo-cpu";
                case "estado":
                    return "/actualizar/actualizar-estado";
                case "tipoConsumoEnergia":
                    return "/actualizar/actualizar-tipo-consumoEnergia";
                case "tipoCapacidad":
                    return "/actualizar/actualizar-tipo-capacidad";
                case "tipoCompania":
                    return "/actualizar/actualizar-compania";
                case "tipoMaterial":
                    return "/actualizar/actualizar-tipo-material";
                case "tipoMemoria":
                    return "/actualizar/actualizar-tipo-memoria";
                case "tipoPuerto":
                    return "/actualizar/actualizar-tipo-puerto";
                case "tipoRefrescante":
                    return "/actualizar/actualizar-tipo-refrescante";
                case "tipoRendimiento":
                    return "/actualizar/actualizar-tipo-rendimiento";
                case "tipoSistemaOperativo":
                    return "/actualizar/actualizar-tipo-sistema-operativo";
                case "tipoTeclado":
                    return "/actualizar/actualizar-tipo-teclado";
                case "tipoTipoRendimientoPrecio":
                    return "/actualizar/actualizar-tipo-tipo-tipo-rendimiento-precio";
                default:
                    return "404";
            }
        }
        return "404";
    }

    public  void eliminarEntidiad(String tablename, Long id){
        switch (tablename) {
            case "computadora":
                computadoraService.eliminarComputadora(id);
                break;
            case "parte":
                parteService.eliminarParte(id);
                break;
            case "usuario":
                usuarioService.eliminarUsuario(id);
            case "bateria":
                bateriaServices.eliminarBateria(id);
                break;
            case "cpu":
                cpuService.eliminarCpu(id);
                break;
            case "discoDuro":
                discoDuroService.eliminarDiscoDuro(id);
                break;
            case "gpu":
                gpuService.eliminarGpu(id);
                break;
            case "memoria":
                memoriaService.eliminarMemoria(id);
            case "puerto":
                puertoService.eliminarPuerto(id);
                break;
            case "teclado":
                tecladoService.eliminarTeclado(id);
            default:
                break;
        }
    }

    public Long convertToLong(String id){
        return Long.parseLong(id);
    }
}