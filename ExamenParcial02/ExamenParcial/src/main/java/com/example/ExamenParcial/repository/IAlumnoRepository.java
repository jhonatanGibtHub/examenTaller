
package com.example.ExamenParcial.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ExamenParcial.model.AlumnoModel;

@Repository
public interface IAlumnoRepository extends CrudRepository<AlumnoModel, Integer> {}