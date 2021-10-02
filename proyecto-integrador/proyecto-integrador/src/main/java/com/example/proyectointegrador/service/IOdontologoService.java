package com.example.proyectointegrador.service;


import com.example.proyectointegrador.DTO.OdontologoDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface IOdontologoService {

    void guardarOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO consultarOdontologo(Long id);
    void actualizarOdontologo(OdontologoDTO odontologoDTO);
    void eliminarOdontologo(Long id);
    Collection<OdontologoDTO> consultarTodos();

}
