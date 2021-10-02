package com.example.proyectointegrador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "domicilios")
@Getter @Setter
public class Domicilio {

    @Id
    @GeneratedValue
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    public Domicilio() {
    }

    public Domicilio(Long id, String calle, String numero, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Domicilio(String calle, String numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }
}
