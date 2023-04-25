package com.co.pds.User.persitence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Long idUsuario;


    private String nombre;

    private String numeroIdentificacion;

    @Column (name = "fecha_nacimiento")
    private Date fechaNacimiento;

    private boolean activo;

    private Dependencia dependencia;

    private Perfil perfil;

    @OneToMany(mappedBy = "usuarios",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private List<Fila> filas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return idUsuario.equals(usuario.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario);
    }
}
