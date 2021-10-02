package com.example.proyectointegrador.DTO;

import com.example.proyectointegrador.model.Odontologo;
import com.example.proyectointegrador.model.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class TurnoDTO{

    private Long id;
    private Date fecha;
    private Paciente paciente;
    private Odontologo odontologo;


}
