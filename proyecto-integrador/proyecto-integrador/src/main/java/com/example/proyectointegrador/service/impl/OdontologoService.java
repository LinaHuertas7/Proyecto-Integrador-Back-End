package com.example.proyectointegrador.service.impl;

import com.example.proyectointegrador.DTO.OdontologoDTO;
import com.example.proyectointegrador.model.Odontologo;
import com.example.proyectointegrador.repository.IOdontologoRepository;
import com.example.proyectointegrador.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

import org.apache.log4j.Logger;

@Service
public class OdontologoService implements IOdontologoService {

    //Agregar dependencia
    @Autowired
    IOdontologoRepository odontologoRepository;

    @Autowired
    private ObjectMapper mapper;

    final static Logger logger = Logger.getLogger(OdontologoService.class);

    //Metodo para guardar odontologo
    @Override
    public void guardarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
        logger.info("El odontologo se ha guardado correctamente");
    }

    //Metodo para consultar odontologo por ID
    @Override
    public OdontologoDTO consultarOdontologo(Long id) {
        OdontologoDTO odontologoDTO = null;
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        if(odontologo.isPresent()){
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }else {
            logger.error("Error al consultar el odontologo con id: " + odontologoDTO.getId());
        }
        return odontologoDTO;
    }

    //Metodo para actualizar odontologo
    @Override
    public void actualizarOdontologo(OdontologoDTO odontologoDTO) {
        if (odontologoDTO.getId() != null) {
            Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
            odontologoRepository.save(odontologo);
            logger.info("El odontologo " + odontologoDTO.getNombre() + " " + odontologoDTO.getApellido() + " se ha actualizado correctmente.");
        } else {
            logger.error("Error al actualizar el dontologo con id: " + odontologoDTO.getId());
        }

    }

    //Metodo para eliminar odontologo por ID
    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
        logger.info("El odontologo con id: " + id + " se ha eliminado correctamente.");
    }

    //Metodo para consultar todos los odontologos
    @Override
    public Collection<OdontologoDTO> consultarTodos() {
        List<Odontologo> odontologos = odontologoRepository.findAll((Sort.by(Sort.Direction.DESC,"id")));

        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        for(Odontologo odontologo : odontologos){
            odontologosDTO.add(mapper.convertValue(odontologo,OdontologoDTO.class));
        }
        return odontologosDTO;
    }

}
