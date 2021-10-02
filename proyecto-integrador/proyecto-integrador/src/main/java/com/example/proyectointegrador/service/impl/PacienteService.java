package com.example.proyectointegrador.service.impl;

import com.example.proyectointegrador.DTO.PacienteDTO;
import com.example.proyectointegrador.model.Paciente;
import com.example.proyectointegrador.repository.IPacienteRepository;
import com.example.proyectointegrador.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteService implements IPacienteService {

    //Agregar dependencia
    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    DomicilioService domicilioService;

    @Autowired
    ObjectMapper mapper;

    final static Logger logger = Logger.getLogger(PacienteService.class);

    //Metodo para guardar paciente
    @Override
    public void guardarPaciente(PacienteDTO pacienteDTO) {
        domicilioService.guardarDomicilio(pacienteDTO);
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        System.out.println(paciente);
        pacienteRepository.save(paciente);
        logger.info("El paciente se ha guardado correctamente");
    }

    //Metodo para consultar paciente por ID
    @Override
    public PacienteDTO consultarPaciente(Long id) {
        PacienteDTO pacienteDTO = null;
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if(paciente.isPresent()){
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }else {
            logger.error("Error al consultar el paciente");
        }
        return pacienteDTO;
    }

    //Metodo para actualizar paciente
    @Override
    public void actualizarPaciente(PacienteDTO pacienteDTO) {
        if(pacienteDTO.getId() != null) {
            domicilioService.actualizarDomicilio(pacienteDTO);
            Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
            pacienteRepository.save(paciente);
            logger.info("El paciente " + pacienteDTO.getNombre() + " " + pacienteDTO.getApellido() + " se ha actualizado correctmente.");
        }else{
            logger.error("Error al actualizar el paciente.");
        }
    }

    //Metodo para eliminar paciente por ID
    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
        logger.info("El paciente con id: " + id + " se ha eliminado correctamente.");
    }

    //Metodo para consultar todos los pacientes
    @Override
    public Collection<PacienteDTO> consultarTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();

        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        for(Paciente paciente : pacientes){
            pacientesDTO.add(mapper.convertValue(paciente,PacienteDTO.class));
        }
        return pacientesDTO;
    }

}
