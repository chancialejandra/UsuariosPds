package com.co.pds.User.Persitence.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "Perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_perfil")
    private Long idPerfil;
    @Column(name ="nombre_perfil")
    private String nombrePerfil;

    @OneToMany(mappedBy = "perfil",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private List<Usuario> usuarios;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Perfil)) return false;
        Perfil perfil = (Perfil) o;
        return idPerfil == perfil.idPerfil;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerfil);
    }
}
