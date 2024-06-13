
package com.univer.service_students.model.entity;
import jakarta.persistence.*;

@Entity
@Table(name= "CURSO")
public class cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_clase")
    private int id;
    @Column(name = "NOMBRE")
    private String name;


}
