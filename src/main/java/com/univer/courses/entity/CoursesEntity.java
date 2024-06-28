
package com.univer.courses.entity;
import jakarta.persistence.*;

@Entity
@Table(name= "CURSO")
public class CoursesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_clase")
    private int id;
    @Column(name = "NOMBRE")
    private String name;
    @Column(name="GRADO")
    private Integer grado;

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
