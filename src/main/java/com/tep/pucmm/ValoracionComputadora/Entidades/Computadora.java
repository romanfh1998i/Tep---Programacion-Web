package com.tep.pucmm.ValoracionComputadora.Entidades;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Roman on 09/10/18.
 */
@Data
@Entity
@Table(name = "computadora")
public class Computadora implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 100)
    private String marca;
    private String color;
    private String numeroSerie;
    @Size(min = 1, max=100)
    private String tamano;
    @Min(value = 1990)
    private Integer anoSalida;
    private Integer numeroSlotMemoria;
    private boolean tieneWebcam = true;
    private boolean esTouch = false;
    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_material_id")
    private TipoMaterial tipoMaterial;
    @ManyToOne(optional = false)
    @JoinColumn(name = "estado_id")
    private Estado estado;
    private Integer cantidadMemoria;
    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_computadora_id")
    private TipoComputadora tipoComputadora;
    @ManyToOne
    @JoinColumn(name = "tipo_sistema_operativo_id")
    private TipoSistemaOperativo tipoSistemaOperativo;
    private boolean tieneCargador;
    @Min(value = 1)
    private Integer cantidadPuertos;
    private boolean tieneFan = true;
    private boolean tieneLectorCDDVD = false;
    private Long usuario;
}
