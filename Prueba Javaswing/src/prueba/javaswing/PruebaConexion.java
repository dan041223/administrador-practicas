/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.javaswing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.util.PSQLException;

/**
 *
 * @author LinkA
 */
public class PruebaConexion {
    String url = "jdbc:postgresql://aws-0-eu-central-1.pooler.supabase.com:5432/postgres?user=postgres.tbzzihapucuohfrrggup&password=Dalexiana1223";
    String user = "postgres.tbzzihapucuohfrrggup";
    String password = "Dalexiana1223";
    public static void main(String[] args) {
        PruebaConexion p = new PruebaConexion();
        p.conectar();
    }
    
    public Connection conectar(){
        Connection con = null;
        try {
             con = DriverManager.getConnection(url);
        } catch (PSQLException ex) {
            Logger.getLogger(PruebaConexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PruebaConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
