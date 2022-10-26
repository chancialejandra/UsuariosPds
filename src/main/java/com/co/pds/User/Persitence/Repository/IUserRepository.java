package com.co.pds.User.Persitence.Repository;

import com.co.pds.User.Persitence.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
