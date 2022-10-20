package com.co.pds.Taller_1_Usuarios_Profundizacion.Persitence.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table (name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private int idUser;

    @Column (name = "date_birth")
    private Date dateBirth;

    private boolean condition;

    @ManyToOne(fetch=FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idDependence")
    private Dependence dependence;

    @ManyToOne(fetch=FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idProfile")
    private Profile profile;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private List<Row> row;

}
