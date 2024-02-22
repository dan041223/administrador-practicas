/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.Usuario;

/**
 *
 * @author LinkA
 */
public class LoginMetodos {
    
    public Usuario obtenerUsuario(String email, String password){
        BBDD bbdd = new BBDD();
        List<Usuario> usuarios = bbdd.obtenerListaUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null;
    }
}
