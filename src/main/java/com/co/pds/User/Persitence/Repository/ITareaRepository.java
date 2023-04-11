package com.co.pds.User.Persitence.Repository;

import com.co.pds.User.Persitence.Entity.Tarea;
import com.co.pds.User.Persitence.Entity.Usuario;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ITareaRepository extends JpaRepository<Tarea,Long> {

}
