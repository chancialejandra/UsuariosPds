package com.co.pds.Taller_1_Usuarios_Profundizacion.Persitence.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "Dependence")
public class Dependence {

    @Id
    @Column(name = "id_dependence")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDependence;

    private String dependenceName;

    @OneToMany(mappedBy = "dependence",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private List<User> users;
}
