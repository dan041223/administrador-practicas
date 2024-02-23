/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;

/**
 *
 * @author LinkA
 */
public class MenuMetodos {
    
    BBDD bbdd = new BBDD();
    
    /*public DefaultTableModel rellenarTablaUltimosUsuarios(JTable tabla){
    DefaultTableModel modeloDefaultTabla = new DefaultTableModel(new Object[]{"Id", "Nombre", "Apellidos", "Email", "Telefono", "Fecha de nacimiento", "Password", "Tipo de usuario"}, 8);
    
    List<Usuario> usuarios = bbdd.obtenerListaUsuarios("SELECT * FROM usuarios ORDER BY id DESC LIMIT 10;");
    for (Usuario usuario : usuarios) {
    modeloDefaultTabla.addRow(new Object[]{
    usuario.getId(),
    usuario.getNombre(),
    usuario.getApellidos(),
    usuario.getEmail(),
    usuario.getTelefono(),
    usuario.getFechaNacimiento(),
    usuario.getPassword(),
    usuario.getTipousuario()});
    }
    
    return modeloDefaultTabla;
    }*/
    
    public DefaultTableModel rellenarTablaUltimosUsuarios(JTable tabla){
        DefaultTableModel modeloDefaultTabla = new DefaultTableModel(new Object[]{"Id", "Nombre", "Apellidos"}, 3);
        
        List<Usuario> usuarios = bbdd.obtenerListaUsuarios("SELECT * FROM usuarios ORDER BY id DESC LIMIT 10;");
        for (Usuario usuario : usuarios) {
            modeloDefaultTabla.addRow(new Object[]{
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellidos()});
        }
        
        return modeloDefaultTabla;
    }
    //int id, String nombre, String apellidos, String email, String telefono, String fechaNacimiento, String password, String tipoUsuario, 
}
