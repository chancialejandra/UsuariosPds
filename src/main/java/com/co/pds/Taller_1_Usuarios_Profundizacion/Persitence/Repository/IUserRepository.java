package com.co.pds.Taller_1_Usuarios_Profundizacion.Persitence.Repository;

import com.co.pds.Taller_1_Usuarios_Profundizacion.Persitence.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
