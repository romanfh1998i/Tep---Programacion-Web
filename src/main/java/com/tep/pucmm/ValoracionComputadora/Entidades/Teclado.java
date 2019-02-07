package com.tep.pucmm.ValoracionComputadora.Entidades;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Roman on 10/10/18.
 */
@Data
@Entity
@Table(name = "teclado")
public class Teclado  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "parte_id")
    private Parte parte;
    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_teclado_id")
    private TipoTeclado tipoTeclado;

}
