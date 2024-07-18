package com.univer.courses.model.request;

public class CursesRequest {

    private String name;
    private Integer grado;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    @Override
    public String toString() {
        return "CursesRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}