package com.co.pds.User.Persitence.Repository;

import com.co.pds.User.Persitence.Entity.Fila;
import com.co.pds.User.Persitence.Entity.Usuario;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IFilaRepository extends JpaRepository<Fila,Long> {

}
