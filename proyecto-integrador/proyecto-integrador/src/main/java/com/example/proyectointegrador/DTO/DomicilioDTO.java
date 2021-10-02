package com.example.proyectointegrador.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DomicilioDTO {

    //Atributos
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    //toString
    @Override
    public String toString() {
        return "DomicilioDTO{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}

