package com.co.pds.User.Persitence.repository;

import com.co.pds.User.Persitence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByNumeroIdentificacion(String numeroIdentificacion);


}
