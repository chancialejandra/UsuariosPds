package com.co.pds.User.Persitence.Repository;

import com.co.pds.User.Persitence.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {
   @Transactional
   Optional<Usuario> findByNumeroIdenficacion(String identificacion);
}
