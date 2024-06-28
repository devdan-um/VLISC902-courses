package com.univer.courses.model.response;

import jakarta.persistence.Column;

import java.util.List;

public class ClaseResponse {
    private int id;
    private String name;
    @Column(name="GRADO")
    private int grado;
   // private List<ClaseResponse> clases;

}
