/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Empresa;

/**
 *
 * @author LinkA
 */
public class BolsaTrabajoMetodos {

    public DefaultTableModel rellenarTablaAlumnos(DefaultTableModel modeloAlumnos, List<Alumno> alumnos) {
        modeloAlumnos.setRowCount(0);
        for (Alumno alumno : alumnos) {
            modeloAlumnos.addRow(new Object[]{
                alumno.getId(),
                alumno.getNombre() + " " + alumno.getApellidos(),
            });
        }
        return modeloAlumnos;
    }

    public DefaultTableModel rellenarTablaEmpresas(DefaultTableModel modeloEmpresas, List<Empresa> empresas) {
        modeloEmpresas.setRowCount(0);
        for (Empresa empresa : empresas) {
            modeloEmpresas.addRow(new Object[]{
                empresa.getId(),
                empresa.getNombre(),
                empresa.getAmbito()
            });
        }
        return modeloEmpresas;
    }
    
}
