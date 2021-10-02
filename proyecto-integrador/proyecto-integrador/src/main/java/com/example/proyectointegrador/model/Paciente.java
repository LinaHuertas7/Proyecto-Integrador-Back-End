package com.example.proyectointegrador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "pacientes")
@Getter @Setter
public class Paciente {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellido;
    private Integer dni;
    private Date fechaIngreso;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private Set<Turno> turnos;

    @OneToOne
    @JoinColumn(name="domicilio_id")
    private Domicilio domicilio;

    public Paciente() {
    }

    public Paciente(Long id, String nombre, String apellido, Integer dni, Date fechaIngreso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
    }

    public Paciente(String nombre, String apellido, Integer dni, Date fechaIngreso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
    }

    public Paciente(String nombre, String apellido, Integer dni, Date fechaIngreso, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", fechaDeIngreso=" + fechaIngreso +
                '}';
    }
}

