package com.univer.courses.model.request;

public class CursesRequest {

    private String name;
    private Integer GRADO;

    public Integer getGRADO() {
        return GRADO;
    }

    public void setGRADO(Integer GRADO) {
        this.GRADO = GRADO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CursesRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}