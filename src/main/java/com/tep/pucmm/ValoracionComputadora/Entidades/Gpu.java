package com.tep.pucmm.ValoracionComputadora.Entidades;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Roman on 11/10/18.
 */
@Data
@Entity
@Table(name = "gpu")
public class  Gpu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @NotNull
    private Integer capacidad;
    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_capacidad_id")
    private TipoCapacidad tipoCapacidad;
    private Float precio;
    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_gpu_id")
    private TipoGPU tipoGPU;
    @ManyToOne(optional = false)
    @JoinColumn(name = "parte_id")
    private Parte parte;
}
