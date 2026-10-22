package com.diego0954_alt.bibliotechj.controller;

import com.diego0954_alt.bibliotechj.model.User;
import com.diego0954_alt.bibliotechj.model.UserManager;

public class UserController {
    
    public void test(){
        UserManager userManager = new UserManager();
        userManager.aVerSiEsVerdad();
    }
    public User buscarUsuario(String rut){
        UserManager admistracionDeUsuarios = new 
        UserManager();

        User usuarioEncontrado = admistracionDeUsuarios.devolverUsuarioPorRut(rut);

        return usuarioEncontrado;
    }

}