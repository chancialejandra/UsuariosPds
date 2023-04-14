package com.co.pds.User.Persitence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter

@Table(name = "Fila")
public class Fila {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_fila")
    private Long idFila;

    private Integer duracion;

    @ManyToOne(fetch= FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idTarea")
    private Tarea tarea;

    @ManyToOne(fetch= FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idUsuario")
    private Usuario usuarios;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fila)) return false;
        Fila fila = (Fila) o;
        return idFila == fila.idFila;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFila);
    }
}
