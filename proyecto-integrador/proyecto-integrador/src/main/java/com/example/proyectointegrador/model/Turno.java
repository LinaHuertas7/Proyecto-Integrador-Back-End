package com.example.proyectointegrador.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue
    private Long id;

    private Date fecha;

    @ManyToOne()
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne()
    @JoinColumn(name = "id_odontologo", nullable = false)
    private Odontologo odontologo;

    public Turno() {
    }

    public Turno(Long id, Date fecha, Paciente paciente, Odontologo odontologo) {
        this.id = id;
        this.fecha = fecha;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }

    public Turno(Date fecha, Paciente paciente, Odontologo odontologo) {
        this.fecha = fecha;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", paciente=" + paciente +
                ", odontologo=" + odontologo +
                '}';
    }
}
