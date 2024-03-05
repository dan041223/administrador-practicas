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
import modelo.Tutor;
import vista.PanelAlumnos;
import static vista.PanelAlumnos.tfBusqueda;
import vista.PanelLogin;
import vista.PanelTutor;
import vista.VentanaAgregarTutor;
import vista.VentanaMasInfoAlumno;
import vista.VentanaMasInfoTutor;

/**
 *
 * @author LinkA
 */
public class TutorMetodos {
    
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
                new VentanaMasInfoTutor().setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                System.out.println("Borrar fila: " + row);
                MessageDialog message = new MessageDialog(((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, tabla)));
                message.showMessage("Confirmacion de borrado", "¿Esta seguro de querer borrar este alumno?");
                if (message.getMessageType()==MessageDialog.MessageType.OK) {
                    int idABorrar = (Integer) tabla.getModel().getValueAt(row, 0);
                    bbdd.borrarTutor(idABorrar);
                    
                    List<Tutor> tutores = rellenarListaTutores("SELECT * FROM tutor_centro where eliminado = FALSE ORDER BY nombre ASC");
                    PanelTutor.tablaTutor = rellenarTablaTutores(PanelTutor.tablaTutor, tutores);
                    
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

    public JTable rellenarTablaTutores(JTable tablaTutor, List<Tutor> tutores) {
        DefaultTableModel modeloDefaultTabla = (DefaultTableModel) tablaTutor.getModel();
        modeloDefaultTabla.setRowCount(0);
        for (Tutor tutor : tutores) {
            modeloDefaultTabla.addRow(new Object[]{
                tutor.getId(),
                tutor.getNombre(),
                tutor.getApellidos(),
                tutor.getTelefono(),
                tutor.getEmail(),
            });
        }
        tablaTutor.setModel(modeloDefaultTabla);
        return tablaTutor;
    }
    
    public List rellenarListaTutores(String query){
        List<Tutor> tutores = bbdd.obtenerListaTutores(query);
        return tutores;
    }

    public void comprobarCampos(JFrame framePadre, String nombre, String apellidos, String telefono, String email) {
        Notification notificacion;
        if (nombre.equals("Nombre del profesor")
                || apellidos.equals("Apellidos")
                || email.equals("Correo electrónico")
                || telefono.equals("Teléfono")
                || email.equals("Ciclo")
              ) {
            notificacion = new Notification(framePadre, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Todos los campos deben de estar rellenos.");
            notificacion.showNotification();
        }else{
            bbdd.agregarTutor(nombre, apellidos,telefono,email);
            notificacion = new Notification(framePadre, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "¡Alumno creado con éxito!");
            notificacion.showNotification();
        }
    }
}
