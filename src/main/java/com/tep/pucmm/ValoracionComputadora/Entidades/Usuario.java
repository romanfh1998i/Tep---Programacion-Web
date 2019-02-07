package com.tep.pucmm.ValoracionComputadora.Entidades;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Roman on 09/10/18.
 */
@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 100)
    private String name;
    @NotNull
    @Size(min = 4, max = 30)
    @Column(unique=true)
    private String username;
    @NotNull
    private String email;
    @Column(name="enabled", nullable = false, columnDefinition = "int default 1")
    private int enable = 1;
    @NotNull(message="La contrasena es invalida")
    @Size(min =6)
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Rol> roles;
    @Size(max = 37)
    private String resetToken;

}
