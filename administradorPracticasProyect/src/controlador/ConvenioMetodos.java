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
import modelo.Convenio;
import vista.PanelAlumnos;
import static vista.PanelAlumnos.tfBusqueda;
import static vista.PanelConvenio.tablaConvenio;
import vista.PanelLogin;
import vista.VentanaMasInfoAlumno;
/**
 *
 * @author LinkA
 */
public class ConvenioMetodos {
    
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
                new VentanaMasInfoAlumno().setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                System.out.println("Borrar fila: " + row);
                MessageDialog message = new MessageDialog(((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, tabla)));
                message.showMessage("Confirmacion de borrado", "¿Esta seguro de querer borrar este alumno?");
                if (message.getMessageType()==MessageDialog.MessageType.OK) {
                    int idABorrar = (Integer) tabla.getModel().getValueAt(row, 0);
                    bbdd.borrarAlumno(idABorrar);
                    
                 //   List<Alumno> alumnos = rellenarListaAlumnos("SELECT * FROM alumnos where eliminado = FALSE ORDER BY nombre ASC");
                  //  PanelAlumnos.tablaAlumnos = rellenarTablaAlumnos(PanelAlumnos.tablaAlumnos, alumnos);
                    
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

    public JTable rellenarTablaConvenio(JTable tablaConvenio, List<Convenio> convenios) {
        DefaultTableModel modeloDefaultTabla = (DefaultTableModel) tablaConvenio.getModel();
        modeloDefaultTabla.setRowCount(0);
        for (Convenio convenio: convenios) {
            modeloDefaultTabla.addRow(new Object[]{
                convenio.getId(),
                convenio.getIdEmpresa(),
                convenio.getIdCentro(),
                convenio.getAnexo2_1(),
                convenio.getAnexo1()
               
            });
        }
        tablaConvenio.setModel(modeloDefaultTabla); 
        return tablaConvenio;
    }
    
    public List rellenarListaConvenio(String query){
        List<Convenio> convenios = bbdd.obtenerListaConvenios(query);
        return convenios;
    }

    /*
     public void comprobarCampos(JFrame framePadre, String id, String id_empresa, String id_centro, FileInputStream anexo1,FileInputStream anexo2) {
        Notification notificacion;
        if (id.equals("Id")
                || id_empresa.equals("Id_Empresa")
                || id_centro.equals("Id_Centro")) {
            notificacion = new Notification(framePadre, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Todos los campos deben de estar rellenos.");
            notificacion.showNotification();
        }else{
            bbdd.agregarConvenio(id, id_empresa, anexo2 ,id_centro, anexo1);
            notificacion = new Notification(framePadre, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "¡Alumno creado con éxito!");
            notificacion.showNotification();
        }
    }
    
    
    
    
    */
   
}
