package com.co.pds.User.Persitence.Repository;

import com.co.pds.User.Persitence.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {
//    boolean findsuarioByNumeroIdenficacion(String identificacion);
}
