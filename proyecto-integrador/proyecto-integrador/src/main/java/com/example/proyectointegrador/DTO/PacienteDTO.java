package com.example.proyectointegrador.DTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter @Setter
public class PacienteDTO {

    //Atributos
    private Long id;
    private String nombre;
    private String apellido;
    private Integer dni;
    private Date fechaIngreso;
    private DomicilioDTO domicilio;

    //toString
    @Override
    public String toString() {
        return "PacienteDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", fechaIngreso=" + fechaIngreso +
                ", domicilio=" + domicilio +
                '}';
    }
}

