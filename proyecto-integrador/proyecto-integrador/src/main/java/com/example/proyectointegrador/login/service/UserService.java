package com.example.proyectointegrador.login.service;


import com.example.proyectointegrador.login.model.Rol;
import com.example.proyectointegrador.login.model.User;
import com.example.proyectointegrador.login.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.getUserByName(userName);

        //Creamos un set con los roles del usuario
        Set<GrantedAuthority> autorizaciones = new HashSet<>();

        for (Rol rol : user.get().getRoles()) {
            //Transformacion de rol al objeto GrantedAuthority
            GrantedAuthority autorizacion = new SimpleGrantedAuthority(rol.getNombre());
            //Agregamos a la colleccion
            autorizaciones.add(autorizacion);
        }

        org.springframework.security.core.userdetails.User userDetail = new org.springframework.security.core.userdetails.User(user.get().getUserName(),"{noop}" + user.get().getPassword(),true,true,true,true,autorizaciones);

        return userDetail;

    }
}
