package com.example.subiquetellevo.entidades;

import java.io.Serializable;

public class Persona implements Serializable {
    private Integer id;
    private String nombre;
    private String correo;
    private String contrasenia;

    public Persona(Integer id, String nombre, String apellido, Integer dni, Integer cuil, String correo, String contrasenia, Integer numero, Integer calificacion) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
