/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

/**
 *
 * @author LinkA
 */
public class LoginMetodos {
    
    public Usuario obtenerUsuario(String email, String password){
        BBDD bbdd = new BBDD();
        String query = "SELECT * FROM usuarios";
        List<Usuario> usuarios = bbdd.obtenerListaUsuarios(query);
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getPassword().equals(password)) {
                crearReemplazarLogin(email);
                return usuario;
            }
        }
        return null;
    }

    public void crearReemplazarLogin(String email) {
        FileWriter fw = null;
        try {
            File file = new File("src\\files\\recuerdame.txt");
            fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(email);
            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(LoginMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limpiarArchivo() {
        FileWriter fw = null;
        try {
            File file = new File("src\\files\\recuerdame.txt");
            fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("   ");
            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(LoginMetodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
