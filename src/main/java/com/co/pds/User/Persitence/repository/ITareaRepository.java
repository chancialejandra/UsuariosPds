package com.co.pds.User.persitence.repository;

import com.co.pds.User.persitence.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITareaRepository extends JpaRepository<Tarea,Long> {
    Optional<Tarea> findBynombreTarea(String nombreTarea);


}
