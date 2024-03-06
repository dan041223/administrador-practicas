/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.AlumnosMetodos.idEscogido;
import elementos.Notification;
import elementos.mensaje.message.MessageDialog;
import elementos.tablas.TableActionCellEditor;
import elementos.tablas.TableActionCellRender;
import elementos.tablas.TableActionEvent;
import java.io.FileInputStream;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Practica;
import vista.PanelAlumnos;
import vista.PanelPractica;
import vista.VentanaMasInfoAlumno;

/**
 *
 * @author usuario
 */
public class PracticaMetodos {
    BBDD bbdd = new BBDD();
    public static int idEscogido;
    
    public JTable prepararRenderizadoCeldas(JTable tabla){
        tabla.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
        return tabla;
    }
    
    public JTable prepararEditadoCeldas(JTable tabla){
        TableActionEvent evento = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("Editar fila: " + row);
                idEscogido = (Integer) tabla.getValueAt(row, 0);
                new VentanaMasInfoAlumno().setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                System.out.println("Borrar fila: " + row);
                MessageDialog message = new MessageDialog(((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, tabla)));
                message.showMessage("Confirmacion de borrado", "¿Esta seguro de querer borrar esta practica?");
                if (message.getMessageType()==MessageDialog.MessageType.OK) {
                    int idABorrar = (Integer) tabla.getModel().getValueAt(row, 0);
                    bbdd.borrarPractica(idABorrar);
                    
                    List<Practica> practicas = rellenarListaPractica("SELECT * FROM practica where eliminado = FALSE ORDER BY nombre ASC");
                    PanelPractica.tablaPractica = rellenarTablaPractica(PanelPractica.tablaPractica, practicas);
                    
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
    
     public List rellenarListaPractica(String query){
        List<Practica> practicas = bbdd.obtenerListaPractica(query);
        return practicas;
    }
     
     public JTable rellenarTablaPractica(JTable tablaPractica, List<Practica> practicas) {
        DefaultTableModel modeloDefaultTabla = (DefaultTableModel) tablaPractica.getModel();
        modeloDefaultTabla.setRowCount(0);
        for (Practica practica : practicas) {
            System.out.println("Una practica mas");
            modeloDefaultTabla.addRow(new Object[]{
                practica.getId(),
                practica.getFecha_inicio(),
                practica.getId_alumno(),
                practica.getAnexo4(),
                practica.getAnexo8(),
                practica.getId_convenio(),
                practica.getFecha_fin(),
            });
        }
        tablaPractica.setModel(modeloDefaultTabla);
        return tablaPractica;
    }
     
     public void comprobarCampos(JFrame framePadre, String idConvenio, String idAlumno, FileInputStream cvASubir1,  FileInputStream cvASubir2) {
        Notification notificacion;
        if (idAlumno.equals("Id del alumno")
                || idConvenio.equals("Id del Convenio")) {
            notificacion = new Notification(framePadre, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Todos los campos deben de estar rellenos.");
            notificacion.showNotification();
        }else{
            bbdd.agregarPractica(idAlumno, idConvenio, cvASubir1, cvASubir2);
            notificacion = new Notification(framePadre, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "¡Practica creada con éxito!");
            notificacion.showNotification();
        }
    }
}
