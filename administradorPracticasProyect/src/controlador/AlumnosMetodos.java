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
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import vista.PanelAlumnos;

/**
 *
 * @author LinkA
 */
public class AlumnosMetodos {
    
    BBDD bbdd = new BBDD();
    
    public JTable prepararRenderizadoCeldas(JTable tabla){
        tabla.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        return tabla;
    }
    
    public JTable prepararEditadoCeldas(JTable tabla){
        TableActionEvent evento = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("Editar fila: " + row);
            }

            @Override
            public void onDelete(int row) {
                System.out.println("Borrar fila: " + row);
                MessageDialog message = new MessageDialog(((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, tabla)));
                message.showMessage("Confirmacion de borrado", "¿Esta seguro de querer borrar este alumno?");
                if (message.getMessageType()==MessageDialog.MessageType.OK) {
                    int idABorrar = (Integer) tabla.getModel().getValueAt(row, 0);
                    bbdd.borrarAlumno(idABorrar);
                    
                    List<Alumno> alumnos = rellenarListaAlumnos("SELECT * FROM alumnos where eliminado = FALSE ORDER BY nombre ASC");
                    PanelAlumnos.tablaAlumnos = rellenarTablaAlumnos(PanelAlumnos.tablaAlumnos, alumnos);
                    
                    Notification notificacion = new Notification(((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, tabla)), Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "¡Alumno eliminado con exito!");
                    notificacion.showNotification();
                }else{
                    Notification notificacion = new Notification(((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, tabla)), Notification.Type.WARNING, Notification.Location.TOP_CENTER, "El alumno no ha sido eliminado");
                    notificacion.showNotification();
                }
            }

            @Override
            public void onView(int row) {
                System.out.println("Ver fila: " + row);
            }
        };
        tabla.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(evento));
        return tabla;
    }

    public JTable rellenarTablaAlumnos(JTable tablaAlumnos, List<Alumno> alumnos) {
        DefaultTableModel modeloDefaultTabla = (DefaultTableModel) tablaAlumnos.getModel();
        modeloDefaultTabla.setRowCount(0);
        for (Alumno alumno : alumnos) {
            modeloDefaultTabla.addRow(new Object[]{
                alumno.getId(),
                alumno.getNombre(),
                alumno.getApellidos(),
                alumno.getTelefono(),
                alumno.getEmail(),
                alumno.getCiclo()
            });
        }
        tablaAlumnos.setModel(modeloDefaultTabla);
        return tablaAlumnos;
    }
    
    public List rellenarListaAlumnos(String query){
        List<Alumno> alumnos = bbdd.obtenerListaAlumnos(query);
        return alumnos;
    }
}
