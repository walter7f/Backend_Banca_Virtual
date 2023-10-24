package com.bancaVirtual.apiBanca;

import com.bancaVirtual.apiBanca.model.User;
import com.bancaVirtual.apiBanca.repository.UserRepositori;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Component
//@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class UserService {
    @Autowired
    private UserRepositori userRepositori;

    public User createuser(User user){
        //return userRepositori.save(user);
        user.setId(String.valueOf(UUID.randomUUID()));
       try {
            return userRepositori.save(user);
        } catch (Exception e) {
            // Manejar la excepción (puedes imprimir logs, lanzar una excepción personalizada, etc.)
            e.printStackTrace();
            throw new RuntimeException("Error al crear el usuario"+ e);
        }
    }

    public User getUserById(UUID id){
        Optional<User> optionalUser= userRepositori.findById(id);
        return optionalUser.get();
    }
    public void deleteUser(UUID id){
        userRepositori.deleteById( id);
    }
    public List<User> getAllUsers(){
        return userRepositori.findAll();
    }
    public User getUserByEmailAndPassword(String email, String password) {
        return userRepositori.findByEmailAndPassword(email, password);
    }
}

