package com.example.proyectointegrador.service.impl;

import com.example.proyectointegrador.DTO.DomicilioDTO;
import com.example.proyectointegrador.DTO.PacienteDTO;
import com.example.proyectointegrador.model.Domicilio;
import com.example.proyectointegrador.repository.IDomicilioRepository;
import com.example.proyectointegrador.service.IDomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DomicilioService implements IDomicilioService {

    //Agregar dependencia
    @Autowired
    IDomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper mapper;

    final static Logger logger = Logger.getLogger(DomicilioService.class);


    //Metodo para guardar domicilio
    @Override
    public void guardarDomicilio(PacienteDTO pacienteDTO) {
        Domicilio domicilio = mapper.convertValue(pacienteDTO.getDomicilio(), Domicilio.class);
        domicilio = domicilioRepository.save(domicilio);
        pacienteDTO.setDomicilio(mapper.convertValue(domicilio, DomicilioDTO.class));
        logger.info("El domicilio se ha guardado correctamente");
    }

    //Metodo para consultar domicilio por ID
    @Override
    public DomicilioDTO consultarDomicilio(Long id) {
        DomicilioDTO domicilioDTO = null;
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        if(domicilio.isPresent()){
            domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
        }else {
            logger.error("Error al consultar el domicilio con id: " + domicilioDTO.getId());
        }
        return domicilioDTO;
    }

    //Metodo para actualizar domicilio
    @Override
    public void actualizarDomicilio(PacienteDTO pacienteDTO) {
        if(pacienteDTO.getId() != null) {
            Domicilio domicilio = mapper.convertValue(pacienteDTO.getDomicilio(), Domicilio.class);
            domicilio = domicilioRepository.save(domicilio);
            pacienteDTO.setDomicilio(mapper.convertValue(domicilio, DomicilioDTO.class));
            logger.info("El domicilio " + domicilio.getId() + " se ha actualizado correctmente.");
        }else{
            logger.error("Error al actualizar el domicilio.");
        }
    }

    //Metodo para eliminar domicilio por ID
    @Override
    public void eliminarDomicilio(Long id) {
        domicilioRepository.deleteById(id);
        logger.info("El domicilio con id: " + id + " se ha eliminado correctamente.");
    }

    //Metodo para consultar todos los domicilios
    @Override
    public Collection<DomicilioDTO> consultarTodos() {
        List<Domicilio> domicilios = domicilioRepository.findAll();

        Set<DomicilioDTO> domiciliosDTO = new HashSet<>();
        for(Domicilio domicilio : domicilios){
            domiciliosDTO.add(mapper.convertValue(domicilio,DomicilioDTO.class));
        }
        return domiciliosDTO;
    }
}
