    package com.example.ExamenParcial.services;

import java.util.List;

import com.example.ExamenParcial.model.AlumnoModel;

public interface IAlumnoService {

    public AlumnoModel add(AlumnoModel model);

    public AlumnoModel update(AlumnoModel model);

    public boolean delete(int id);

    public List<AlumnoModel> findAll();

    public AlumnoModel findById(int id);
}
