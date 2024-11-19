

package com.example.ExamenParcial.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumno")
public class AlumnoModel{
 
    @Id

    @Column(name = "id")
    public Integer id;

    @Column(name = "nombre")
    public String nombre;

    @Column(name = "nota")
    public Double nota;
    
    // Getter y Setter para id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

      // Constructor vacío
      public AlumnoModel() {}

}