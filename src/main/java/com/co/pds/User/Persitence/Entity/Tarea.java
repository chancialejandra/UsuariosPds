package com.co.pds.User.Persitence.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "Tarea")
public class Tarea {

    @Id
    @Column (name = "id_tarea")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTarea;
    @Column(name = "nombre_tarea")
    private String nombreTarea;

    @OneToMany(mappedBy = "tarea",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private List<Fila> filas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarea)) return false;
        Tarea tarea = (Tarea) o;
        return idTarea == tarea.idTarea;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTarea);
    }
}
