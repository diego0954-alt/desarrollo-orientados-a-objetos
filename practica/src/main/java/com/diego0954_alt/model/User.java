package com.diego0954_alt.model;

public class User {
    private String nombre;
    private String rut;
    private String email;
    private int edad;
    private Boolean puede_solicitar_prestamo;

    public User(String nombre, String rut, String email, int edad, Boolean puede_solicitar_prestamo) {
        this.nombre = nombre;
        this.rut = rut;
        this.email = email;
        this.edad = edad;
        this.puede_solicitar_prestamo = puede_solicitar_prestamo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Boolean getPuede_solicitar_prestamo() {
        return puede_solicitar_prestamo;
    }

    public void setPuede_solicitar_prestamo(Boolean puede_solicitar_prestamo) {
        this.puede_solicitar_prestamo = puede_solicitar_prestamo;
    }

    
    
}
