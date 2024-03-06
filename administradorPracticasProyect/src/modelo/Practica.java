/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LinkA
 */
public class Practica {
    int id;
    String fecha_inicio;
    int id_alumno;
    byte[] anexo4;
    byte[] anexo8;
    int id_convenio;
    String fecha_fin;
    Boolean eliminado;

    public Practica() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public byte[] getAnexo4() {
        return anexo4;
    }

    public void setAnexo4(byte[] anexo4) {
        this.anexo4 = anexo4;
    }

    public byte[] getAnexo8() {
        return anexo8;
    }

    public void setAnexo8(byte[] anexo8) {
        this.anexo8 = anexo8;
    }

    public int getId_convenio() {
        return id_convenio;
    }

    public void setId_convenio(int id_convenio) {
        this.id_convenio = id_convenio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }
    
    
   
}
