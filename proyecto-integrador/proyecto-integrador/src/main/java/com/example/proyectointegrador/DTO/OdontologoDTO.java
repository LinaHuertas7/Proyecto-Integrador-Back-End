package com.example.proyectointegrador.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OdontologoDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private Integer matricula;

    @Override
    public String toString() {
        return "OdontologoDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}

