package com.diego0954_alt.bibliotech;

import com.diego0954_alt.bibliotech.model.User;
import com.diego0954_alt.bibliotech.model.UserManager;

public class UserController {

        private UserManager manager;

    public UserController() {
        manager = new UserManager();
    }

    public boolean datosDisponibles() {
        return manager.isDatosCargados();
    }

    public User buscarUsuario(String rut_ingresado) {
        String rut_limpio = rut_ingresado.trim();
        return manager.buscarPorRut(rut_limpio);
    }
    
}
