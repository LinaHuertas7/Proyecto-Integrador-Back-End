package com.example.proyectointegrador.service.impl;

import com.example.proyectointegrador.DTO.TurnoDTO;
import com.example.proyectointegrador.model.Turno;
import com.example.proyectointegrador.repository.ITurnoRepository;
import com.example.proyectointegrador.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoService implements ITurnoService {

    //Agregar dependencia
    @Autowired
    ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    PacienteService pacienteService;

    @Autowired
    OdontologoService odontologoService;

    final static Logger logger = Logger.getLogger(TurnoService.class);

    //Controlador de turnos
    private void controladorTurnos(TurnoDTO turnoDTO){

        /*OdontologoDTO odontologoEncontrado  = odontologoService.consultarOdontologo(turnoDTO.getOdontologo().getId());
        PacienteDTO pacienteEncontrado  = pacienteService.consultarPaciente(turnoDTO.getPaciente().getId());

        turnoDTO.setOdontologo(odontologoEncontrado);
        turnoDTO.setPaciente(pacienteEncontrado);*/

        Turno turno = mapper.convertValue(turnoDTO, Turno.class);

       /* Odontologo odontologo = mapper.convertValue(odontologoEncontrado, Odontologo.class);
        Paciente paciente = mapper.convertValue(pacienteEncontrado, Paciente.class);*/

        System.out.println(turnoDTO);


        turnoRepository.save(turno);

    }

    //Metodo para guardar turno
    @Override
    public void guardarTurno(TurnoDTO turnoDTO) {
        if(pacienteService.consultarPaciente(turnoDTO.getPaciente().getId()) != null
                && odontologoService.consultarOdontologo(turnoDTO.getOdontologo().getId()) != null){

            controladorTurnos(turnoDTO);
            logger.info("El turno se ha guardado correctamente");
        }else{
            logger.error("Error");
        }
    }

    //Metodo para consultar turno por ID
    @Override
    public TurnoDTO consultarTurno(Long id) {
        TurnoDTO turnoDTO = null;
        Optional<Turno> turno = turnoRepository.findById(id);
        if(turno.isPresent()){
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        }else {
            logger.error("Error al consultar el turno ");
        }
        return turnoDTO;
    }

    //Metodo para actualizar turno
    @Override
    public void actualizarTurno(TurnoDTO turnoDTO) {
        if(pacienteService.consultarPaciente(turnoDTO.getPaciente().getId()) != null
                && odontologoService.consultarOdontologo(turnoDTO.getOdontologo().getId()) != null
                && turnoDTO.getId() != null){

            controladorTurnos(turnoDTO);

            logger.info("El turno con id: " + turnoDTO.getId() + " se ha actualizado correctmente.");

        }else {
            logger.error("Error al actualizar turno");
        }
    }

    //Metodo para eliminar turno por ID
    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
        logger.info("El turno con id: " + id + " se ha eliminado correctamente.");
    }

    //Metodo para consultar todos los turnos
    @Override
    public Collection<TurnoDTO> consultarTodos() {
        List<Turno> turnos = turnoRepository.findAll();

        Set<TurnoDTO> turnosDTO = new HashSet<>();
        for(Turno turno : turnos){
            turnosDTO.add(mapper.convertValue(turno,TurnoDTO.class));
        }
        return turnosDTO;
    }
}
