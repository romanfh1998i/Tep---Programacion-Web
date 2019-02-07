package com.tep.pucmm.ValoracionComputadora.Entidades;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Roman on 25/11/18.
 */
@Data
@Entity
@Table(name = "valor")
public class Valor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "parte_id")
    private Parte parte;
    private String descripcion;
    private float subScore;
}
