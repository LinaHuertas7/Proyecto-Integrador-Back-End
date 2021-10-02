package com.example.proyectointegrador.repository;

import com.example.proyectointegrador.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {

    /*@Query("from pacientes p where p.id like %:id%")
    Paciente actualizarPacienteById(@Param("id") Long id);*/

    /*@Query("select p from pacientes p where p.id = :id")
    Paciente actualizarPacienteById(@Param("id") Long id);*/


}
