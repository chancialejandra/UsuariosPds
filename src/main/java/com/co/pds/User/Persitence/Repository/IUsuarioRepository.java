package com.co.pds.User.Persitence.Repository;

import com.co.pds.User.Persitence.Repository.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {

    Boolean findByNumeroIdentificacion(String numeroIdentificacion);


}
