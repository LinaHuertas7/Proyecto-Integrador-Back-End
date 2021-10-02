package com.example.proyectointegrador.controller;

import com.example.proyectointegrador.DTO.OdontologoDTO;
import com.example.proyectointegrador.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    //Agregar la dependencia
    @Autowired
    OdontologoService odontologoService;

    //Guardar Odontologo
    @PostMapping
    public ResponseEntity<?> guardarOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        odontologoService.guardarOdontologo(odontologoDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Guardado Correctamente");
    }

    //Consultar odontologo por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> consultarOdontologo(@PathVariable Long id) {
        OdontologoDTO odontologoDTO = odontologoService.consultarOdontologo(id);

        if(odontologoDTO.getId() != null) {
            return ResponseEntity.ok(odontologoDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrado");
        }
    }

    //Consultar todos los odontologos
    @GetMapping
    public Collection<OdontologoDTO> consultarTodos(){
        return odontologoService.consultarTodos();
    }

    //Actualizar odontologos
    @PutMapping
    public ResponseEntity<?> actualizarOdontologo(@RequestBody OdontologoDTO odontologoDTO) {

        if (odontologoDTO != null) {
            odontologoService.actualizarOdontologo(odontologoDTO);
            return ResponseEntity.ok(odontologoDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error al actualizar");
        }
    }

    //Eliminar odontologo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id) {

        if (odontologoService.consultarOdontologo(id) != null) {
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error al eliminar");
        }
    }

}




