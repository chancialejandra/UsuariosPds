package com.co.pds.User.persitence.repository;

import com.co.pds.User.persitence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByNumeroIdentificacion(String numeroIdentificacion);


}
