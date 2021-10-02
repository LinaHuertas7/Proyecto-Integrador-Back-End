package com.example.proyectointegrador;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                /*.antMatchers("/index.html").hasRole("USER")*/
                .antMatchers("/odontologoAlta.html").hasRole("ADMIN")
                .antMatchers("/odontologosList.html").hasRole("ADMIN")
                .antMatchers("/pacienteAlta.html").hasRole("ADMIN")
                .antMatchers("/pacientesList.html").hasRole("ADMIN")
              /*  .antMatchers("/turnoAlta.html").hasRole("ADMIN")
                .antMatchers("/turnosList.html").hasRole("ADMIN")
                .antMatchers("/turnoAlta.html").hasRole("USER")
                .antMatchers("/turnosList.html").hasRole("USER")*/
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .and()
                .logout();


    }
}
