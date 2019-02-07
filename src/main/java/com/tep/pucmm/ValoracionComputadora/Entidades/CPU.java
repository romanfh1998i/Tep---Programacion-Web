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
@Table(name = "cpu")
public class CPU implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float precio;
    private Float consumo_energia;
    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_consumo_energia_id")
    private TipoConsumoEnergia tipoConsumoEnergia;
    @ManyToOne(optional = false)
    @JoinColumn(name = "parte_id")
    private Parte parte;
    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_refrescante_id")
    private TipoRefrescante tipoRefrescante;
    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_rendimiento_id")
    private TipoRendimiento tipoRendimiento;
    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_cpu_id")
    private TipoCPU tipoCPU;
}
