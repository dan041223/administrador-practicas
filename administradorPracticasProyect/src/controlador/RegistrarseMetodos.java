/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import elementos.Notification;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JTextField;
import vista.PanelLogin;

/**
 *
 * @author LinkA
 */
public class RegistrarseMetodos {
    
    BBDD bbdd = new BBDD();
    
    public void comprobarCampos(JFrame framePadre, String nombre, String apellidos, String email, String telefono, String fechaNacimiento, String password, String tipoUsuario){
        Notification notificacion;
        if (nombre.equals("Nombre")
                || apellidos.equals("Apellidos")
                || email.equals("Introduzca su correo electrónico")
                || telefono.equals("Teléfono")
                || fechaNacimiento.equals("Fecha de nacimiento (DD-MM-YYYY)")
                || password.equals("*************")
                || tipoUsuario.equals("Selecciona los permisos")
                || nombre.isEmpty()
                || apellidos.isEmpty()
                || email.isEmpty()
                || telefono.isEmpty()
                || fechaNacimiento.isEmpty()
                || password.isEmpty()
                || tipoUsuario.isEmpty()) {
            notificacion = new Notification(framePadre, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Todos los campos deben de estar rellenos.");
            notificacion.showNotification();
        }else{
            bbdd.agregarUsuario(nombre, apellidos, email, telefono, fechaNacimiento, password, tipoUsuario);
            framePadre.dispose();
            PanelLogin panelLogin = new PanelLogin();
            panelLogin.setVisible(true);
            notificacion = new Notification(panelLogin, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "¡Usuario creado con éxito!");
            notificacion.showNotification();
        }
    }
}
