package modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LinkA
 */
public class Anexo22 {
    int id;
    int idCentro;
    String familiaProfesional;
    String cicloFormativo;
    byte[] anexo22;
    boolean eliminado;

    public Anexo22() {
       this.id = 0;
        this.idCentro = 0;
        this.familiaProfesional = "";
        this.cicloFormativo = "";
        this.eliminado= false;
    }
    
    public Anexo22(int id, int idCentro, String familiaProfesional, String cicloFormativo, byte[] anexo22, boolean eliminado) {
        this.id = id;
        this.idCentro = idCentro;
        this.familiaProfesional = familiaProfesional;
        this.cicloFormativo = cicloFormativo;
        this.anexo22 = anexo22;
        this.eliminado= eliminado;
    }

    public int getId() {
        return id;
    }

    public int getIdCentro() {
        return idCentro;
    }

    public String getFamiliaProfesional() {
        return familiaProfesional;
    }

    public String getCicloFormativo() {
        return cicloFormativo;
    }

    public byte[] getAnexo22() {
        return anexo22;
    }
    
     public boolean getEliminado() {
        return eliminado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }

    public void setFamiliaProfesional(String familiaProfesional) {
        this.familiaProfesional = familiaProfesional;
    }

    public void setCicloFormativo(String cicloFormativo) {
        this.cicloFormativo = cicloFormativo;
    }

    public void setAnexo22(byte[] anexo22) {
        this.anexo22 = anexo22;
    }
    
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
}
