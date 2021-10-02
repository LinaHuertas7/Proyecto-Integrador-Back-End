package com.example.proyectointegrador.service;

import com.example.proyectointegrador.DTO.TurnoDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface ITurnoService {

    void guardarTurno(TurnoDTO turnoDTO);
    TurnoDTO consultarTurno(Long id);
    void actualizarTurno(TurnoDTO turnoDTO);
    void eliminarTurno(Long id);
    Collection<TurnoDTO> consultarTodos();

}
