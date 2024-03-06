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
import java.io.FileInputStream;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import modelo.Anexo22;
import vista.PanelAnexo22;
import vista.VentanaMasInfoUsuario;

/**
 *
 * @author Alejandro.panicio
 */
public class AnexoMetodos {
    BBDD bbdd = new BBDD();
    public static int idEscogido;
    
    public JTable prepararRenderizadoCeldas(JTable tabla){
        tabla.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
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
                message.showMessage("Confirmacion de borrado", "¿Esta seguro de querer borrar este anexo?");
                if (message.getMessageType()==MessageDialog.MessageType.OK) {
                    int idABorrar = (Integer) tabla.getModel().getValueAt(row, 0);
                    bbdd.borrarAnexo(idABorrar);
                    
                    List<Anexo22> anexos = rellenarListaAnexo("SELECT * FROM anexo22 where eliminado = FALSE ORDER BY id ASC");
                    PanelAnexo22.tablaAnexos = rellenarTablaAnexo(PanelAnexo22.tablaAnexos, anexos);
                    
                    Notification notificacion = new Notification(((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, tabla)), Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "¡Anexo eliminado con exito!");
                    notificacion.showNotification();
                }else{
                    Notification notificacion = new Notification(((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, tabla)), Notification.Type.WARNING, Notification.Location.TOP_CENTER, "El Anexo no ha sido eliminado");
                    notificacion.showNotification();
                }
            }
        };
        tabla.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(evento));
        return tabla;
    }
    
    public JTable rellenarTablaAnexo(JTable tablaAnexos, List<Anexo22> anexos) {
        DefaultTableModel modeloDefaultTabla = (DefaultTableModel) tablaAnexos.getModel();
         modeloDefaultTabla.setRowCount(0);
        for (Anexo22 anexo : anexos) {
            modeloDefaultTabla.addRow(new Object[]{
                anexo.getId(),
                anexo.getIdCentro(),
                anexo.getFamiliaProfesional(),
                anexo.getCicloFormativo(),              
                anexo.getAnexo22(),
                anexo.getEliminado(),
            });
        }
        tablaAnexos.setModel(modeloDefaultTabla);
        return tablaAnexos;
    }
    
    public List rellenarListaAnexo(String query){
        List<Anexo22> anexos = bbdd.obtenerListaAnexo22(query);
        return anexos;
    }
    
    public void comprobarCampos(JFrame framePadre, String idCentro, String familiaProfesional, String ciclo, FileInputStream cvASubir) {
        Notification notificacion;
        if (idCentro.equals("Id del Centro")
                || familiaProfesional.equals("Familia Profesional")
                || ciclo.equals("ciclo")
                || idCentro.isEmpty()
                || familiaProfesional.isEmpty()
                || ciclo.isEmpty()
                || ciclo.isEmpty()) {
            notificacion = new Notification(framePadre, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Todos los campos deben de estar rellenos.");
            notificacion.showNotification();
        }else{
            bbdd.agregarAnexo(idCentro, familiaProfesional, ciclo, cvASubir);
            notificacion = new Notification(framePadre, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "¡Anexo creado con éxito!");
            notificacion.showNotification();
        }
    }
}
