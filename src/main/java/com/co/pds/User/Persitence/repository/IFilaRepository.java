package com.co.pds.User.Persitence.repository;


import com.co.pds.User.Persitence.entity.Fila;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFilaRepository extends JpaRepository<Fila,Long> { }
