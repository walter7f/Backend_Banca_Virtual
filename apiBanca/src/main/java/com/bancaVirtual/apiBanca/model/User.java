package com.bancaVirtual.apiBanca.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@Entity
@Table(name = "users", schema ="BANCA_DB")
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "Varchar(36)")
    private String id;

    private String userName;
    private String email;
    private String password;

   /* public User() {
    }

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    /*public void setPassword(String password) {
        this.password = password;
    }*/
    public void setPassword(String password) {
        // Utilizar un encriptador para almacenar la contraseña de forma segura
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }
}
