package com.co.pds.User.Persitence.Entity;

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
   // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Integer idUser;

    private String name;

    @Column (name = "date_birth")
    private Date dateBirth;

    private boolean condition;

    @ManyToOne(fetch=FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idDependence")
    private Dependence dependence;

    @ManyToOne(fetch=FetchType.EAGER,cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "idProfile")
    private Profile profile;

    @OneToMany(mappedBy = "users",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private List<Row> row;

}
