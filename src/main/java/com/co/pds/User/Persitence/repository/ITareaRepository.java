package com.co.pds.User.Persitence.repository;


import com.co.pds.User.Persitence.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITareaRepository extends JpaRepository<Tarea,Long> {

}
