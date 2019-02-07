package com.tep.pucmm.ValoracionComputadora.Entidades;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Roman on 10/10/18.
 */
@Data
@Entity
@Table(name = "disco_duro")
public class DiscoDuro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Integer capacidad;
    private Integer durabilidad; // A revisar
    private Float velocidad;
    private Float precio;
    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_capacidad_id")
    private TipoCapacidad tipoCapacidad;
    @ManyToOne(optional = false)
    @JoinColumn(name = "parte_id")
    private Parte parte;
    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_disco_duro_id")
    private TipoDiscoDuro tipoDiscoDuro;
}
