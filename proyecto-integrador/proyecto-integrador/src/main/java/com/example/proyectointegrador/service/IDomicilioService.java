package com.example.proyectointegrador.service;

import com.example.proyectointegrador.DTO.DomicilioDTO;
import com.example.proyectointegrador.DTO.PacienteDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface IDomicilioService {

    void guardarDomicilio(PacienteDTO pacienteDTO);
    DomicilioDTO consultarDomicilio(Long id);
    void actualizarDomicilio(PacienteDTO pacienteDTO);
    void eliminarDomicilio(Long id);
    Collection<DomicilioDTO> consultarTodos();

}
