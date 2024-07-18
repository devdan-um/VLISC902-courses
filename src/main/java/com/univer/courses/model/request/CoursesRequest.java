package com.univer.courses.model.request;

public class CoursesRequest {
    private String name;

    private Integer grado;

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CoursesRequest{" +
                "name='" + name + '\'' +
                '}';
    }

}