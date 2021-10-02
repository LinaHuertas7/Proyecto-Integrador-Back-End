package com.example.proyectointegrador.controller;

import com.example.proyectointegrador.DTO.PacienteDTO;

import com.example.proyectointegrador.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> guardarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        pacienteService.guardarPaciente(pacienteDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Guardado Correctamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarPaciente(@PathVariable Long id) {
        PacienteDTO pacienteDTO = pacienteService.consultarPaciente(id);

        if(pacienteDTO.getId() != null) {
            return ResponseEntity.ok(pacienteDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
        }
    }


    //@GetMapping
    /*public ResponseEntity<List<Odontologo>> consultarTodos(){
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }*/

    @GetMapping
    public Collection<PacienteDTO> consultarTodos(){
        return pacienteService.consultarTodos();
    }

    @PutMapping
    public ResponseEntity<?> actualizarPaciente(@RequestBody PacienteDTO pacienteDTO) {

        if (pacienteService.consultarPaciente(pacienteDTO.getId()) != null) {
            pacienteService.actualizarPaciente(pacienteDTO);
            return ResponseEntity.ok(pacienteDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error al actualizar");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPciente(@PathVariable Long id) {

        if (pacienteService.consultarPaciente(id) != null) {
            pacienteService.eliminarPaciente(id);
            return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error al eliminar");
        }
    }

}

