package com.tep.pucmm.ValoracionComputadora.Entidades;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Roman on 11/10/18.
 */
@Data
@Entity
@Table(name = "tipo_gpu")
public class TipoGPU implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 100)
    private String descripcion;
    @ManyToOne(optional = false)
    @JoinColumn(name = "compania_id")
    private Compania compania;
}
