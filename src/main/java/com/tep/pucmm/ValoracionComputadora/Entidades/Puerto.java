package com.tep.pucmm.ValoracionComputadora.Entidades;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Roman on 10/10/18.
 */
@Data
@Entity
@Table(name = "puerto")
public class Puerto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "parte_id")
    private Parte parte;
    private Integer cantidad;
    private Float version;
    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_puerto_id")
    private  TipoPuerto tipoPuerto;
}
