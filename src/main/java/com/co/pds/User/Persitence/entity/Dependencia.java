package com.co.pds.User.persitence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "Dependencia")
public class Dependencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_dependencia")
    private Long idDependence;
    @Column(name = "nombre_dependencia")
    private String nombreDependencia;

    @OneToMany(mappedBy = "dependencia",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private List<Usuario> usuarios;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dependencia)) return false;
        Dependencia that = (Dependencia) o;
        return idDependence == that.idDependence;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDependence);
    }
}
