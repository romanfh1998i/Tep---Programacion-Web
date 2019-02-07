package com.tep.pucmm.ValoracionComputadora.Entidades;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Roman on 10/10/18.
 */
@Data
@Entity
@Table(name = "memoria")
public class Memoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_memoria_id")
    private TipoMemoria tipoMemoria;
    @Size(max = 100)
    private String marca;
    @NotNull
    private Integer capacidad;
    private Float precio;
    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_capacidad_id")
    private TipoCapacidad tipoCapacidad;
    @ManyToOne(optional = false)
    @JoinColumn(name = "parte_id")
    private Parte parte;
}
