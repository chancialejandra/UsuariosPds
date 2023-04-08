package com.co.pds.User.Persitence.Repository;

import com.co.pds.User.Persitence.Entity.Usuario;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {

//    boolean existsUsuarioByNumeroIdenficacion(String identificacion);
}
