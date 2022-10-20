package com.co.pds.Taller_1_Usuarios_Profundizacion.Persitence.Entity;

import lombok.*;

import javax.persistence.*;
@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Row")
public class Row {

    @Id
    @Column(name = "id_row")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRow;

    private int duration;

    @ManyToOne(fetch= FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idTask")
    private Task task;

    @ManyToOne(fetch= FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idUser")
    private User user;
}
