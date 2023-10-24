package com.bancaVirtual.apiBanca.repository;

import com.bancaVirtual.apiBanca.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepositori extends /*CrudRepository*/ JpaRepository<User, UUID> {
    User findByEmailAndPassword(String email, String password);
}
