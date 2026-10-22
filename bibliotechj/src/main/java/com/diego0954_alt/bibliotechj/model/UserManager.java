package com.diego0954_alt.bibliotechj.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UserManager {

    private ArrayList<User> user = new ArrayList<>();

    public UserManager() {
        loadUsers();
    }

    public void loadUsers(){
        InputStream cadena = getClass().getResourceAsStream("/user.json");
        InputStreamReader reader = new InputStreamReader(cadena);
        
        Gson gson = new Gson();

        User[] users = gson.fromJson(reader, User[].class);

        for( User usuario : users ){

            user.add(usuario);
            }
        }

    public User devolverUsuarioPorRut(String rut) {
        for (User usuario : user) {
            if (usuario.getRut().equals(rut)) {
                return usuario;
            }
        }
        return null;

    }

    public void aVerSiEsVerdad() {
        for (User u : user) {
            System.out.println(u.getRut());
            System.out.println(u.getNombre());
            System.out.println(u.getemail());
            System.out.println(u.getEdad());
            System.out.println(u.isPuede_solicitar_prestamos());
        }
    }
}
