package com.example.proyectointegrador.service;

import com.example.proyectointegrador.DTO.PacienteDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface IPacienteService {

    void guardarPaciente(PacienteDTO pacienteDTO);
    PacienteDTO consultarPaciente(Long id);
    void actualizarPaciente(PacienteDTO pacienteDTO);
    void eliminarPaciente(Long id);
    Collection<PacienteDTO> consultarTodos();

}