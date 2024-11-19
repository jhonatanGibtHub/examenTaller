package com.example.ExamenParcial.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ExamenParcial.model.AlumnoModel;
import com.example.ExamenParcial.repository.IAlumnoRepository;

@Service
public class AlumnoService implements IAlumnoService {

    @Autowired
    IAlumnoRepository repository;

    @Override
    public AlumnoModel add(AlumnoModel model) {
        return repository.save(model);  // Guarda el alumno en la base de datos
    }

    @Override
    public AlumnoModel update(AlumnoModel model) {
        return repository.save(model);  // Actualiza el alumno en la base de datos
    }

    @Override
    public boolean delete(int id) {
        // Verifica si el alumno existe antes de eliminarlo
        if (repository.existsById(id)) {
            repository.deleteById(id);  // Elimina el alumno por ID
            return true;  // Indica que la eliminación fue exitosa
        }
        return false;  // Si el alumno no existe, retorna false
    }

    @Override
    public List<AlumnoModel> findAll() {
        return (List<AlumnoModel>) repository.findAll();  // Devuelve todos los alumnos
    }

    @Override
    public AlumnoModel findById(int id) {
        // Cambiado para evitar NullPointerException, ahora retorna null si no encuentra el alumno
        return repository.findById(id).orElse(null);  // Retorna el alumno o null si no se encuentra
    }
}
