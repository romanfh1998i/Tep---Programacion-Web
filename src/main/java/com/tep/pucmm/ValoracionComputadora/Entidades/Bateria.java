package com.tep.pucmm.ValoracionComputadora.Entidades;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Roman on 10/10/18.
 */
@Data
@Entity
@Table(name = "bateria")
public class Bateria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "parte_id")
    private Parte parte;
    private Long precio;
    @NotNull
    private Short cantidadCelulas;
    private Float cantidadVoltaje;
    private String numeroSerie;
}

