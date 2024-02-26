/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import elementos.Notification;
import elementos.mensaje.message.MessageDialog;
import elementos.tablas.TableActionCellEditor;
import elementos.tablas.TableActionCellRender;
import elementos.tablas.TableActionEvent;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Usuario;
import vista.PanelAlumnos;
import static vista.PanelAlumnos.tfBusqueda;
import vista.PanelLogin;
import vista.PanelUsuarios;
import vista.VentanaMasInfoAlumno;
import vista.VentanaMasInfoUsuario;

/**
 *
 * @author LinkA
 */
public class UsuariosMetodos {
    
    BBDD bbdd = new BBDD();
    public static int idEscogido;
    
    public JTable prepararRenderizadoCeldas(JTable tabla){
        tabla.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        return tabla;
    }
    
    public JTable prepararEditadoCeldas(JTable tabla){
        TableActionEvent evento = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("Editar fila: " + row);
                idEscogido = (Integer) tabla.getValueAt(row, 0);
                new VentanaMasInfoUsuario().setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                System.out.println("Borrar fila: " + row);
                MessageDialog message = new MessageDialog(((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, tabla)));
                message.showMessage("Confirmacion de borrado", "¿Esta seguro de querer borrar este usuario?");
                if (message.getMessageType()==MessageDialog.MessageType.OK) {
                    int idABorrar = (Integer) tabla.getModel().getValueAt(row, 0);
                    bbdd.borrarUsuario(idABorrar);
                    
                    List<Usuario> usuarios = rellenarListaUsuarios("SELECT * FROM usuarios where eliminado = FALSE ORDER BY id ASC");
                    PanelUsuarios.tablaUsuarios = rellenarTablaUsuarios(PanelUsuarios.tablaUsuarios, usuarios);
                    
                    Notification notificacion = new Notification(((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, tabla)), Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "¡Alumno eliminado con exito!");
                    notificacion.showNotification();
                }else{
                    Notification notificacion = new Notification(((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, tabla)), Notification.Type.WARNING, Notification.Location.TOP_CENTER, "El alumno no ha sido eliminado");
                    notificacion.showNotification();
                }
            }
        };
        tabla.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(evento));
        return tabla;
    }

    public JTable rellenarTablaUsuarios(JTable tablaUsuarios, List<Usuario> usuarios) {
        DefaultTableModel modeloDefaultTabla = (DefaultTableModel) tablaUsuarios.getModel();
        modeloDefaultTabla.setRowCount(0);
        for (Usuario usuario : usuarios) {
            modeloDefaultTabla.addRow(new Object[]{
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellidos(),
                usuario.getTelefono(),
                usuario.getEmail(),
                usuario.getFechaNacimiento(),
                usuario.getPassword(),
                usuario.getTipousuario()
            });
        }
        tablaUsuarios.setModel(modeloDefaultTabla);
        return tablaUsuarios;
    }
    
    public List rellenarListaUsuarios(String query){
        List<Usuario> usuarios = bbdd.obtenerListaUsuarios(query);
        return usuarios;
    }

    public void comprobarCampos(JFrame framePadre, String nombre, String apellidos, String password, String fecha_nacimiento, String email, String telefono, String tipo_usuario) {
        Notification notificacion;
        if (nombre.equals("Nombre del usuario")
                || apellidos.equals("Apellidos")
                || email.equals("Correo electrónico")
                || telefono.equals("Teléfono")
                || fecha_nacimiento.equals("Fecha de nacimiento (DD-MM-YYYY)")
                || password.equals("Password")
                || tipo_usuario.equals("Dni")
                || nombre.isEmpty()
                || apellidos.isEmpty()
                || email.isEmpty()
                || telefono.isEmpty()
                || fecha_nacimiento.isEmpty()
                || password.isEmpty()
                || tipo_usuario.isEmpty()) {
            notificacion = new Notification(framePadre, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Todos los campos deben de estar rellenos.");
            notificacion.showNotification();
        }else{
            bbdd.agregarUsuario(nombre, apellidos, fecha_nacimiento, password, email, tipo_usuario, telefono);
            notificacion = new Notification(framePadre, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "¡Usuario creado con éxito!");
            notificacion.showNotification();
        }
    }

    public JTable rellenarTablaAlumnos(JTable tablaUsuarios, List<Usuario> usuarios) {
        DefaultTableModel modeloDefaultTabla = (DefaultTableModel) tablaUsuarios.getModel();
        modeloDefaultTabla.setRowCount(0);
        for (Usuario usuario : usuarios) {
            modeloDefaultTabla.addRow(new Object[]{
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellidos(),
                usuario.getTelefono(),
                usuario.getEmail(),
                usuario.getFechaNacimiento(),
                usuario.getPassword(),
                usuario.getTipousuario().toString()
            });
        }
        tablaUsuarios.setModel(modeloDefaultTabla);
        return tablaUsuarios;
    }
}
