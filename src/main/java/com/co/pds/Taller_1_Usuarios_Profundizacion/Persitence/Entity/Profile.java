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
@Table(name = "Profile")
public class Profile {

    @Id
    @Column(name = "id_profile")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProfile;

    private String profileName;

    @OneToMany(mappedBy = "profile",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private List<User> users;
}
