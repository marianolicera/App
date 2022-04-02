package com.example.subiquetellevo.utilidades;

public class Utilidades {

    //Constantes campos tabla personas
    public static final String TABLA_PERSONA="Persona";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="Nombre";
    public static final String CAMPO_CORREO="Correo";
    public static final String CAMPO_CONTRASENIA="Contrasenia";


    public static final String CREAR_TABLA_PERSONA="create table "+TABLA_PERSONA+"" +
            "("+CAMPO_ID+" integer primary key autoincrement, "+CAMPO_NOMBRE+" text,"+CAMPO_CORREO+" text, "+CAMPO_CONTRASENIA+" text);";




}
