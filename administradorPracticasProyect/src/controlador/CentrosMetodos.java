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

import modelo.Centro;


import vista.PanelCentro;
import static vista.PanelCentro.tablaCentro;

import vista.VentanaMasInfoAlumno;
import vista.VentanaMasInfoCentro;

/**
 *
 * @author LinkA
 */
public class CentrosMetodos {
    
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
                new VentanaMasInfoCentro().setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                System.out.println("Borrar fila: " + row);
                MessageDialog message = new MessageDialog(((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, tabla)));
                message.showMessage("Confirmacion de borrado", "¿Esta seguro de querer borrar este centro?");
                if (message.getMessageType()==MessageDialog.MessageType.OK) {
                    int idABorrar = (Integer) tabla.getModel().getValueAt(row, 0);
                    bbdd.borrarCentro(idABorrar);
                    
                    List<Centro> centros = rellenarListaCentro("SELECT * FROM centro where eliminado = FALSE ORDER BY nombre ASC");
                    PanelCentro.tablaCentro = rellenarTablaCentros(PanelCentro.tablaCentro, centros);
                    
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

    public JTable rellenarTablaCentros(JTable tablaCentro, List<Centro> centros) {
        DefaultTableModel modeloDefaultTabla = (DefaultTableModel) tablaCentro.getModel();
        modeloDefaultTabla.setRowCount(0);
        for (Centro centro : centros) {
            modeloDefaultTabla.addRow(new Object[]{
                centro.getId(),
                centro.getNombre(),
                centro.getEmail(),
                centro.getTelefono(),
                centro.getDireccion(),
                centro.getId_tutor()
            });
        }
        tablaCentro.setModel(modeloDefaultTabla);
        return tablaCentro;
    }
    
    public List rellenarListaCentro(String query){
        List<Centro> centros = bbdd.obtenerListaCentros(query);
        return centros;
    }

    public void comprobarCampos(JFrame framePadre, String nombre, String email, String telefono, String direccion, String id_tutor) {
        Notification notificacion;
        if (nombre.equals("Nombre del Centro")
                || email.equals("Email")
                || telefono.equals("Teléfono")
                || direccion.equals("Dirección")
                || id_tutor.equals("Id_Tutor")
              ) {
            notificacion = new Notification(framePadre, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Todos los campos deben de estar rellenos.");
            notificacion.showNotification();
        }else{
            bbdd.agregarCentro(nombre, email, telefono, direccion, id_tutor);
            notificacion = new Notification(framePadre, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "¡Centro creado con éxito!");
            notificacion.showNotification();
        }
    }
    
    
}
