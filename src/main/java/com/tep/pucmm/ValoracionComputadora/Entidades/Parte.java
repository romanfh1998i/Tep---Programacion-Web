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
@Table(name = "parte")
public class Parte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "computadora_id")
    private Computadora computadora;
    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private  String nombre;
}
