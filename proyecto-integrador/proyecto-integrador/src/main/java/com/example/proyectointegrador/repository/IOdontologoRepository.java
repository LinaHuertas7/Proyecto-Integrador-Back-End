package com.example.proyectointegrador.repository;

import com.example.proyectointegrador.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {

    /*@Query("from odontologos o where o.id like %:id%")
    Odontologo actualizarOdontologoById(@Param("id") Long id);*/

    /*@Query("FROM odontologos o WHERE o.id = o.id")
    Odontologo actualizarOdontologoById(@Param("id") Long id);*/
}


