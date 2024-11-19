package com.example.ExamenParcial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ExamenParcial.constants.Nohardcodeo;
import com.example.ExamenParcial.model.AlumnoModel;
import com.example.ExamenParcial.services.AlumnoService;

@RestController
@RequestMapping(Nohardcodeo.ALUMNO_BASE)
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @GetMapping(Nohardcodeo.GET_ALL)
    public ResponseEntity<List<AlumnoModel>> getAll() {
        try {
            List<AlumnoModel> alumnos = alumnoService.findAll();
            return new ResponseEntity<>(alumnos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(Nohardcodeo.CREATE)
    public ResponseEntity<String> create(@RequestBody AlumnoModel model) {
        try {
            alumnoService.add(model);
            return new ResponseEntity<>("Alumno creado con éxito", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el alumno", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(Nohardcodeo.GET_BY_ID)
    public ResponseEntity<AlumnoModel> getById(@PathVariable int id) {
        try {
            AlumnoModel alumno = alumnoService.findById(id);
            if (alumno != null) {
                return new ResponseEntity<>(alumno, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(Nohardcodeo.UPDATE)
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody AlumnoModel model) {
        try {
            // Establecer el ID del modelo para asegurarse de que se actualice el registro correcto
            model.setId(id);
    
            // Llamar al servicio para actualizar el registro en la base de datos
            AlumnoModel updatedAlumno = alumnoService.update(model);
            
            if (updatedAlumno != null) {
                return new ResponseEntity<>("Registro actualizado correctamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Alumno no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el registro", HttpStatus.BAD_REQUEST);
        }
    }
    

    @DeleteMapping(Nohardcodeo.DELETE)
    public ResponseEntity<String> delete(@PathVariable int id) {
        try {
            boolean isDeleted = alumnoService.delete(id);
            if (isDeleted) {
                return new ResponseEntity<>("Registro eliminado correctamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Alumno no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
