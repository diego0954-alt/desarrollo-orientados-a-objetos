package com.diego0954_alt.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UserManager {
    private ArrayList<User> Lista_usuarios = new ArrayList<>();

public UserManager(){
    loadUsers();
}

public void loadUsers(){
    for (User usuarios : users) {
        Lista_usuarios.add(usuarios);
        
    }

}

public User devolverUsuarioPorRut(String rut){
    for (User usuario : Lista_usuarios) {
        if (usuario.getRut().equals(rut)){
            return usuario;
        }
    }
    return null;
}

InputStream cadena = getClass().getResourceAsStream("/users.json");
InputStreamReader reader = new InputStreamReader(cadena);

Gson gson = new Gson();
User[] users = gson.fromJson(reader, User[].class);
    
    
}
