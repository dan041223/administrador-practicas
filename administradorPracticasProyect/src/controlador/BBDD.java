/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Alumno;
import modelo.TIPOUSUARIO;
import modelo.Usuario;
import org.postgresql.util.PSQLException;

/**
 *
 * @author LinkA
 */
public class BBDD {
    String url = "jdbc:postgresql://aws-0-eu-central-1.pooler.supabase.com:5432/postgres?user=postgres.tbzzihapucuohfrrggup&password=Dalexiana1223";
    String user = "postgres.tbzzihapucuohfrrggup";
    String password = "Dalexiana1223";

    public static void main(String[] args) {
        BBDD p = new BBDD();
        p.conectar();
        /*p.subirArchivo();*/
        p.descargarArchivo();
    }

    public Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url);
        } catch (PSQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public List obtenerListaUsuarios(String query){
        Usuario usuario;
        List<Usuario> usuarios = null;
        try {
            Connection con = conectar();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            usuarios = new ArrayList<>();
            while (rs.next()) {                
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                usuario.setPassword(rs.getString("password"));
                String tipo_usuario = rs.getString("tipo_usuario");
                
                if (tipo_usuario.equals("administrador")) {
                usuario.setTipousuario(TIPOUSUARIO.ADMINISTRADOR);
                }else if (tipo_usuario.equals("tutor")) {
                usuario.setTipousuario(TIPOUSUARIO.TUTOR);
                }
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
    
    public void subirArchivo() throws IOException{
        //Nos conectamos a la BBDD
        Connection con = conectar();
        FileInputStream fis = null;
        try {
            //Creamos objeto archivo del archivo que queremos subir a la bbdd (No se hardcodearia, se pediria al usuario un archivo con el JFileChooser)
            File f = new File("src\\img\\add_profile_img.png");
            //Hacemos objeto FileInputStream porque queremos pasar el archivo a Bytes
            fis = new FileInputStream(f);
            PreparedStatement ps = con.prepareStatement("INSERT INTO prueba values(?,?,?)");
            ps.setInt(1, 1);
            //El archivo que ha sido pasado a bytes (fis) se mete como stream de binario de la siguiente forma
            ps.setBinaryStream(2, fis, fis.available());
            //Tambien metemos el nombre del archivo en otra columna para que, al descargarlo, tenga el mismo nombre y la misma extension
            ps.setString(3, f.getName());
            ps.executeUpdate();
            System.out.println("Archivo introducido");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void descargarArchivo() {
        try {
            String query = "select * from prueba where id = 1";
            Connection connection = conectar();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                //Creamos array de bytes donde meteremos los bytes resultado de convertir anteriormente el archivo a bytes
                byte[] datosBinarios = resultSet.getBytes("archivos");
                //Obtenemos el nombre del archivo (guardado en la tercera columna al insertar el archivo)
                String nombreArchivo = resultSet.getString("nombreArchivo");
                //Le decimos la ruta donde queremos que se descargue. En este caso esta hardcodeado, pero debe ser pedido al usuario con otro JFileChooser
                String rutaDescarga = "src\\imgGuardadas\\" + nombreArchivo;
                //Le decimos al FileOutputStream donde vamos a descargar el archivo
                //El FileOutputStream crea un archivo en esa direccion
                FileOutputStream fos = new FileOutputStream(rutaDescarga);
                //Escribimos en el archivo creado la informacion en binario
                fos.write(datosBinarios);
                System.out.println("Archivo descargado!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void agregarUsuario(String nombre, String apellidos, String email, String telefono, String fechaNacimiento, String password, String tipoUsuario) {
        Connection con;
        try {
            SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
            Date fechaFormateada = formateador.parse(fechaNacimiento);
            con = conectar();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO usuarios(nombre, apellidos, email, telefono, fecha_nacimiento, password, tipo_usuario) "
                    + "values ('" + nombre + "'"
                            + ", '" + apellidos + "'"
                            + ", '" + email + "'"
                            + ", '" + telefono + "'"
                            + ", '" + fechaFormateada + "'"
                            + ", '" + password + "'"
                            + ", '" + tipoUsuario + "')");
        } catch (ParseException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    List<Alumno> obtenerListaAlumnos(String query) {
        Alumno alumno;
        List<Alumno> alumnos = null;
        try {
            Connection con = conectar();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            alumnos = new ArrayList<>();
            while (rs.next()) {                
                alumno = new Alumno();
                alumno.setId(rs.getInt("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellidos(rs.getString("apellidos"));
                alumno.setDni(rs.getString("dni"));
                alumno.setEmail(rs.getString("email"));
                alumno.setTelefono(rs.getString("telefono"));
                alumno.setDireccion(rs.getString("direccion"));
                alumno.setNumSeguridadSocial(rs.getString("numSeguridadSocial"));
                alumno.setCiclo(rs.getString("ciclo"));
                alumno.setEstado(rs.getBoolean("estado"));
                alumno.setCv(rs.getBytes("curriculum"));
                alumno.setIdCentro(rs.getInt("id_centro"));
                
                alumnos.add(alumno);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnos;
    }

    void borrarAlumno(int idABorrar) {
        Connection con;
        try {
            con = conectar();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE alumnos SET eliminado = TRUE WHERE id = " + idABorrar + ";");
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
