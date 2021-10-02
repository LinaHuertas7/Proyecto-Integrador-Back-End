package com.example.proyectointegrador.controller;

import com.example.proyectointegrador.DTO.TurnoDTO;
import com.example.proyectointegrador.service.impl.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    //Agregar la dependencia
    @Autowired
    TurnoService turnoService;

    //Guardar Turno
    @PostMapping
    public ResponseEntity<?> guardarTurno(@RequestBody TurnoDTO turnoDTO) {
        turnoService.guardarTurno(turnoDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Guardado Correctamente");
    }

    //Consultar turno por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> consultarTurno(@PathVariable Long id) {
        TurnoDTO turnoDTO = turnoService.consultarTurno(id);

        if(turnoDTO.getId() != null) {
            return ResponseEntity.ok(turnoDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
        }
    }

    //Consultar todos los turnos
    @GetMapping
    public Collection<TurnoDTO> consultarTodos(){
        return turnoService.consultarTodos();
    }

    //Actualizar Turnos
    @PutMapping
    public ResponseEntity<?> actualizarTurnos(@RequestBody TurnoDTO turnoDTO) {

        if (turnoService.consultarTurno(turnoDTO.getId()) != null){
            turnoService.actualizarTurno(turnoDTO);
            return ResponseEntity.ok(turnoDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error al actualizar");
        }
    }

    //Elimitar Turno por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurnos(@PathVariable Long id) {

        if (turnoService.consultarTurno(id) != null) {
            turnoService.eliminarTurno(id);
            return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error al eliminar");
        }
    }
}

