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
public class Convenio {
    
    private int id;
    private int idEmpresa;
    private  int idCentro; 
    byte[] anexo2_1;
    byte[] anexo1;
    boolean estado;
    boolean buscando;

    public Convenio() {
    }

    public Convenio(int id, int idEmpresa, int idCentro, byte[] anexo2_1, byte[] anexo1, boolean estado, boolean buscando) {
        this.id = id;
        this.idEmpresa = idEmpresa;
        this.idCentro = idCentro;
        this.anexo2_1 = anexo2_1;
        this.anexo1 = anexo1;
        this.estado = estado;
        this.buscando = buscando;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }

    public void setAnexo2_1(byte[] anexo2_1) {
        this.anexo2_1 = anexo2_1;
    }

    public void setAnexo1(byte[] anexo1) {
        this.anexo1 = anexo1;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setBuscando(boolean buscando) {
        this.buscando = buscando;
    }

    public int getId() {
        return id;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public int getIdCentro() {
        return idCentro;
    }

    public byte[] getAnexo2_1() {
        return anexo2_1;
    }

    public byte[] getAnexo1() {
        return anexo1;
    }

    public boolean isEstado() {
        return estado;
    }

    public boolean isBuscando() {
        return buscando;
    }
    
    
    
    
}
