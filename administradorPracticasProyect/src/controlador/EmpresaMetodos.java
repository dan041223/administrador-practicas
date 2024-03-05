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

import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import modelo.Empresa;


import vista.PanelEmpresa;
import vista.VentanaMasInfoEmpresa;



/**
 *
 * @author LinkA
 */
public class EmpresaMetodos {
    
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
                new VentanaMasInfoEmpresa().setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                System.out.println("Borrar fila: " + row);
                MessageDialog message = new MessageDialog(((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, tabla)));
                message.showMessage("Confirmacion de borrado", "¿Esta seguro de querer borrar esta empresa?");
                if (message.getMessageType()==MessageDialog.MessageType.OK) {
                    int idABorrar = (Integer) tabla.getModel().getValueAt(row, 0);
                    bbdd.borrarAlumno(idABorrar);
                    
                    List<Empresa> empresas = rellenarListaEmpresa("SELECT * FROM empresa where eliminado = FALSE ORDER BY nombre ASC");
                    PanelEmpresa.tablaEmpresa = rellenarTablaEmpresa(PanelEmpresa.tablaEmpresa, empresas);
                    
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

    public JTable rellenarTablaEmpresa(JTable tablaEmpresas, List<Empresa> empresas) {
        DefaultTableModel modeloDefaultTabla = (DefaultTableModel) tablaEmpresas.getModel();
        modeloDefaultTabla.setRowCount(0);
        for (Empresa empresa : empresas) {
            modeloDefaultTabla.addRow(new Object[]{
                empresa.getId(),
                empresa.getNombre(),
                empresa.getCif(),
                empresa.getDireccion(),
                empresa.getDuenio(),
                empresa.getAmbito(),
                empresa.getTelefono(),
                empresa.getEmail(),
                empresa.getTutor(),
                empresa.getEmail(),
                empresa.getTelefono_contacto(),
                empresa.getNombre_contacto(),
                empresa.getEmail_contacto(),
            });
        }
        tablaEmpresas.setModel(modeloDefaultTabla);
        return tablaEmpresas;
    }
    
    public List rellenarListaEmpresa(String query){
        List<Empresa> empresas = bbdd.obtenerListaEmpresas(query);
        return empresas;
    }

    public void comprobarCampos(JFrame framePadre, String nombre, String cif, String direccion, String duenio, String ambito, String telefono, String email, String tutor, String telefono_contacto,String nombre_contacto,String email_contacto ) {
        Notification notificacion;
        if (nombre.equals("Nombre de la empresa")
                || cif.equals("Cif")
                || direccion.equals("Dirección")
                || duenio.equals("Dueño")
                || ambito.equals("Ambito")
                || telefono.equals("Teléfono")   
                || email.isEmpty()
                || tutor.isEmpty()
                || telefono_contacto.isEmpty()
                || nombre_contacto.isEmpty()
                || email_contacto.isEmpty())
                {
                  
            notificacion = new Notification(framePadre, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Todos los campos deben de estar rellenos.");
            notificacion.showNotification();
        }else{
            bbdd.agregarEmpresa(nombre, cif, direccion, duenio, ambito, telefono, email,  tutor,  nombre_contacto,  telefono_contacto, email_contacto );
            notificacion = new Notification(framePadre, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "¡Empresa creado con éxito!");
            notificacion.showNotification();
        }
    }
}
