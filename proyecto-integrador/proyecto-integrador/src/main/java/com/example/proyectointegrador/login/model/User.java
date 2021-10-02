package com.example.proyectointegrador.login.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Users")
@Setter
@Getter
public class User {

    //Atributos
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String password;

    //Establecemos la relacion
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UserRoles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<Rol> roles;
}

