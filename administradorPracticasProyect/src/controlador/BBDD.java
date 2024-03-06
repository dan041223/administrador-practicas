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
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import modelo.Alumno;
import modelo.Centro;
import modelo.Convenio;
import modelo.Empresa;
import modelo.Item;
import modelo.Necesidad;
import modelo.TIPOUSUARIO;
import modelo.Tutor;
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

    public List obtenerListaUsuarios(String query) {
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
                usuario.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                usuario.setPassword(rs.getString("password"));
                String tipo_usuario = rs.getString("tipo_usuario");

                if (tipo_usuario.equals("administrador")) {
                    usuario.setTipousuario(TIPOUSUARIO.ADMINISTRADOR);
                } else if (tipo_usuario.equals("tutor")) {
                    usuario.setTipousuario(TIPOUSUARIO.TUTOR);
                }
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    public void subirArchivo() throws IOException {
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

    ArrayList<Alumno> obtenerListaAlumnos(String query) {
        Alumno alumno;
        ArrayList<Alumno> alumnos = null;
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
                alumno.setDireccion(rs.getString("direccion"));
                alumno.setNumSeguridadSocial(rs.getString("numSeguridadSocial"));
                alumno.setTelefono(rs.getString("telefono"));
                alumno.setCiclo(rs.getString("ciclo"));
                alumno.setCv(rs.getBytes("curriculum"));

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

    public Alumno obtenerAlumno(int idEscogido) {
        Alumno alumno = new Alumno();
        try {
            Connection con = conectar();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from alumnos where id = " + idEscogido + "");
            if (rs.next()) {
                alumno.setId(rs.getInt("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellidos(rs.getString("apellidos"));
                alumno.setDni(rs.getString("dni"));
                alumno.setEmail(rs.getString("email"));
                alumno.setDireccion(rs.getString("direccion"));
                alumno.setNumSeguridadSocial(rs.getString("numSeguridadSocial"));
                alumno.setTelefono(rs.getString("telefono"));
                alumno.setCiclo(rs.getString("ciclo"));
                alumno.setCv(rs.getBytes("curriculum"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumno;
    }
    
    public int modificarEmpresa(int idEmpresa, String nombre, String cif, String direccion, String duenio, String ambito, String telefono, String email, String tutor, String telefono_contacto, String nombre_contacto, String email_contacto) {
        Connection con;
        int filasMod = 0;
        try {
            con = conectar();
            // SQL para la actualización
            String sql = "UPDATE empresa SET nombre=?, cif=?, direccion=?, dueño=?, ambito=?, telefono=?, email=?, tutor=?, telefono_contacto=?, nombre_contacto=?, email_contacto=? "
                    + "WHERE \"idEmpresa\"=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            // Establecer los parámetros con los nuevos valores
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, cif);
            preparedStatement.setString(3, direccion);
            preparedStatement.setString(4, duenio);
            preparedStatement.setString(5, ambito);
            preparedStatement.setString(6, telefono);
            preparedStatement.setString(7, email);
            preparedStatement.setString(8, tutor);
            preparedStatement.setString(9, telefono_contacto);
            preparedStatement.setString(10, nombre_contacto);
            preparedStatement.setString(11, email_contacto);
            preparedStatement.setInt(12, idEmpresa);

            filasMod = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasMod;
    }
    
    public void borrarEmpresa(int idABorrar){
        Connection con;
        try {
            con = conectar();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE empresa SET eliminado = TRUE WHERE \"idEmpresa\" = " + idABorrar + ";");
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int modificarAlumno(int idAlumno, String nombre, String apellidos, String dni, String direccion, String email, String numSS, String telefono, String ciclo, byte[] cvActual, FileInputStream cvASubir) {
        Connection con;
        int filasMod = 0;
        try {
            con = conectar();
            // SQL para la actualización
            String sql = "UPDATE alumnos SET nombre=?, apellidos=?, dni=?, direccion=?, "
                    + "email=?, \"numSeguridadSocial\"=?, telefono=?, ciclo=?, curriculum=? WHERE id=?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            // Establecer los parámetros con los nuevos valores
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellidos);
            preparedStatement.setString(3, dni);
            preparedStatement.setString(4, direccion);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, numSS);
            preparedStatement.setString(7, telefono);
            preparedStatement.setString(8, ciclo);
            if (cvActual == null) {
                preparedStatement.setBinaryStream(9, cvASubir);
            } else {
                preparedStatement.setBytes(9, cvActual);
            }
            preparedStatement.setInt(10, idAlumno);

            filasMod = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasMod;
    }

    public int agregarAlumno(String nombre, String apellidos, String dni, String direccion, String email, String numSS, String telefono, String ciclo, FileInputStream cvASubir) {
        int filasMod = 0;
        try {
            Connection con = conectar();
            String query = "INSERT INTO alumnos(nombre, apellidos, dni, direccion, email, \"numSeguridadSocial\", telefono, ciclo, curriculum) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellidos);
            preparedStatement.setString(3, dni);
            preparedStatement.setString(4, direccion);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, numSS);
            preparedStatement.setString(7, telefono);
            preparedStatement.setString(8, ciclo);
            preparedStatement.setBinaryStream(9, cvASubir);

            filasMod = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasMod;
    }

    void borrarUsuario(int idABorrar) {
        Connection con;
        try {
            con = conectar();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE usuarios SET eliminado = TRUE WHERE id = " + idABorrar + ";");
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int modificarUsuario(int idUsuario, String nombre, String apellidos, String fecha_nacimiento, String password, String email, String telefono, String tipo_usuario) {
        Connection con;
        int filasMod = 0;
        try {
            con = conectar();
            Statement stmt = con.createStatement();
            // SQL para la actualización
            String sql = "UPDATE usuarios SET nombre='" + nombre + "', apellidos='" + apellidos + "', fecha_nacimiento='" + fecha_nacimiento + "', password='" + password + "', "
                    + "email='" + email + "', telefono='" + telefono + "', tipo_usuario='" + tipo_usuario + "' WHERE id=" + idUsuario + "";
            filasMod = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasMod;
    }

    public Usuario obtenerUsuario(int idEscogido) {
        Usuario usuario = new Usuario();
        try {
            Connection con = conectar();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from usuarios where id = " + idEscogido + "");
            if (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("password"));
                String tipoUsuario = rs.getString("tipo_usuario");
                if (tipoUsuario.equalsIgnoreCase("ADMINISTRADOR")) {
                    usuario.setTipousuario(TIPOUSUARIO.ADMINISTRADOR);
                } else {
                    usuario.setTipousuario(TIPOUSUARIO.TUTOR);
                }
                usuario.setTelefono(rs.getString("telefono"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    public List<Empresa> obtenerListaEmpresasBuscando() {
        Empresa empresa;
        List<Empresa> empresas = null;
        try {
            Connection con = conectar();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM empresa WHERE buscando = TRUE and eliminado = FALSE");
            empresas = new ArrayList<>();
            while (rs.next()) {
                empresa = new Empresa();
                empresa.setId(rs.getInt("idEmpresa"));
                empresa.setNombre(rs.getString("nombre"));
                empresa.setCif(rs.getString("cif"));
                empresa.setDuenio(rs.getString("dueño"));
                empresa.setEmail(rs.getString("email"));
                empresa.setTelefono(rs.getString("telefono"));
                empresa.setDireccion(rs.getString("direccion"));
                empresa.setAmbito(rs.getString("ambito"));
                empresa.setTutor(rs.getString("tutor"));
                empresa.setNombre_contacto(rs.getString("nombre_contacto"));
                empresa.setEmail_contacto(rs.getString("email_contacto"));
                empresa.setBuscando(rs.getBoolean("buscando"));

                empresas.add(empresa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empresas;
    }

    public List<Alumno> obtenerListaAlumnosBuscando() {
        Alumno alumno;
        List<Alumno> alumnos = null;
        try {
            Connection con = conectar();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM alumnos WHERE buscando = TRUE and eliminado = FALSE");
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
                alumno.setEstado(rs.getBoolean("eliminado"));
                alumno.setCv(rs.getBytes("curriculum"));
                alumno.setIdCentro(rs.getInt("id_centro"));
                alumno.setBuscando(rs.getBoolean("buscando"));

                alumnos.add(alumno);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnos;
    }

    public int agregarBolsa(Alumno alumnoSeleccionado, Empresa empresaSeleccionada) {
        int filasMod = 0;
        try {
            Connection con = conectar();
            String query = "INSERT INTO bolsa(id_alumno, id_empresa) VALUES (?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, alumnoSeleccionado.getId());
            preparedStatement.setInt(2, empresaSeleccionada.getId());

            filasMod = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasMod;
    }

    public void quitarBuscandoAlumno(int id) {
        Connection con;
        int filasMod = 0;
        try {
            con = conectar();
            Statement stmt = con.createStatement();
            // SQL para la actualización
            String sql = "UPDATE alumnos SET buscando = FALSE WHERE id=" + id + "";
            filasMod = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Alumno> obtenerListaAlumnosBuscandoPorPalabra(String valorIntroducidoAlumnos) {
        Alumno alumno;
        List<Alumno> alumnos = null;
        try {
            Connection con = conectar();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM alumnos WHERE CAST(\"idEmpresa\" AS TEXT) LIKE '%" + valorIntroducidoAlumnos
                    + "%' "
                    + "OR nombre LIKE '%" + valorIntroducidoAlumnos + "%' "
                    + "OR apellidos LIKE '%" + valorIntroducidoAlumnos + "%' "
                    + "ORDER BY id ASC");
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
                alumno.setEstado(rs.getBoolean("buscando"));
                alumno.setBuscando(rs.getBoolean("buscando"));
                alumno.setCv(rs.getBytes("curriculum"));
                alumno.setIdCentro(rs.getInt("id_centro"));

                alumnos.add(alumno);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnos;
    }

    public List<Empresa> obtenerListaEmpresasBuscandoPorPalabra(String valorIntroducidoEmpresas) {
        Empresa empresa;
        List<Empresa> empresas = null;
        try {
            Connection con = conectar();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM empresa WHERE CAST(\"idEmpresa\" AS TEXT) LIKE '%" + valorIntroducidoEmpresas
                    + "%' "
                    + "OR nombre LIKE '%" + valorIntroducidoEmpresas + "%' "
                    + "OR ambito LIKE '%" + valorIntroducidoEmpresas + "%' "
                    + "ORDER BY \"idEmpresa\" ASC");
            empresas = new ArrayList<>();
            while (rs.next()) {
                empresa = new Empresa();
                empresa.setId(rs.getInt("\"idEmpresa\""));
                empresa.setNombre(rs.getString("nombre"));
                empresa.setCif(rs.getString("cif"));
                empresa.setDuenio(rs.getString("dueño"));
                empresa.setEmail(rs.getString("email"));
                empresa.setTelefono(rs.getString("telefono"));
                empresa.setDireccion(rs.getString("direccion"));
                empresa.setAmbito(rs.getString("ambito"));
                empresa.setTutor(rs.getString("tutor"));
                empresa.setNombre_contacto(rs.getString("nombre_contacto"));
                empresa.setEmail_contacto(rs.getString("email_contacto"));
                empresa.setBuscando(rs.getBoolean("buscando"));

                empresas.add(empresa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empresas;
    }

    public int editarNecesidad(int id, int asir, int dam, int daw, int fin, int mark) {
        int filasMod = 0;
        try {
            Connection con;
            
            con = conectar();
            Statement stmt = con.createStatement();
            System.out.println(dam + " " + daw + " " + asir + " " + fin + " " + mark + " " + id + " ");
            // SQL para la actualización
            String sql = "UPDATE necesidades SET \"numDAM\" = " + dam + ", "
                    + "\"numDAW\" = " + daw + ", "
                    + "\"numASIR\" = " + asir + ", "
                    + "\"numFIN\" = " + fin + ", "
                    + "\"numMARK\" = " + mark + " "
                    + "WHERE id_empresa =" + id + ";";
            filasMod = stmt.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasMod;
    }
    
    public Necesidad obtenerNecesidadDeEmpresa(Empresa empresa){
        Necesidad ne = null;
        try {
            Connection con;
            con = conectar();
            Statement stmt = con.createStatement();
            System.out.println(empresa.getId());
            ResultSet rs = stmt.executeQuery("select * from necesidades where id_empresa = " + empresa.getId());
            if (rs.next()) {                
                ne = new Necesidad();
                ne.setNumDAM(rs.getInt("numDAM"));
                ne.setNumDAW(rs.getInt("numDAW"));
                ne.setNumASIR(rs.getInt("numASIR"));
                ne.setNumMARK(rs.getInt("numMARK"));
                ne.setNumFIN(rs.getInt("numFIN"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ne;
    }
        
    // Empresas 
    List<Empresa> obtenerListaEmpresas(String query) {
        Empresa empresa;
        List<Empresa> empresas = null;
        try {
            Connection con = conectar();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            empresas = new ArrayList<>();
            while (rs.next()) {
                empresa = new Empresa();
                empresa.setId(rs.getInt("idEmpresa"));
                empresa.setNombre(rs.getString("nombre"));
                empresa.setCif(rs.getString("cif"));
                empresa.setDireccion(rs.getString("direccion"));
                empresa.setDuenio(rs.getString("dueño"));
                empresa.setAmbito(rs.getString("ambito"));
                empresa.setTelefono(rs.getString("telefono"));
                empresa.setEmail(rs.getString("email"));
                empresa.setTutor(rs.getString("tutor"));
                empresa.setNombre_contacto(rs.getString("nombre_contacto"));
                empresa.setTelefono_contacto(rs.getString("telefono_contacto"));
                empresa.setEmail_contacto(rs.getString("email_contacto"));

                empresas.add(empresa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empresas;

    }

    List<Tutor> obtenerListaTutores(String query) {
        Tutor tutor;
        List<Tutor> tutores = null;
        try {
            Connection con = conectar();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            tutores = new ArrayList<>();
            while (rs.next()) {
                tutor = new Tutor();
                tutor.setId(rs.getInt("id"));
                tutor.setNombre(rs.getString("nombre"));
                tutor.setApellidos(rs.getString("apellidos"));
                tutor.setTelefono(rs.getString("telefono"));
                tutor.setEmail(rs.getString("email"));

                tutores.add(tutor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tutores;

    }

    public int agregarEmpresa(String nombre, String cif, String direccion, String duenio, String ambito, String telefono, String email, String tutor, String nombre_contacto, String telefono_contacto, String email_contacto) {
        int filasMod = 0;
        try {
            Connection con = conectar();
            String query = "INSERT INTO empresa(nombre, cif, direccion, dueño, ambito,  email, telefono, tutor, telefono_contacto, nombre_contacto, email_contacto) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, cif);
            preparedStatement.setString(3, direccion);
            preparedStatement.setString(4, duenio);
            preparedStatement.setString(5, ambito);
            preparedStatement.setString(6, telefono);
            preparedStatement.setString(7, email);
            preparedStatement.setString(8, tutor);
            preparedStatement.setString(9, telefono_contacto);
            preparedStatement.setString(10, nombre_contacto);
            preparedStatement.setString(11, email_contacto);

            filasMod = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasMod;
    }

    public Empresa obtenerEmpresa(int idEscogido) {
        Empresa empresa = new Empresa();
        try {
            Connection con = conectar();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from empresa where \"idEmpresa\" = " + idEscogido + "");
            if (rs.next()) {
                empresa.setId(rs.getInt("idEmpresa"));
                empresa.setNombre(rs.getString("nombre"));
                empresa.setCif(rs.getString("cif"));
                empresa.setDireccion(rs.getString("direccion"));
                empresa.setDuenio(rs.getString("dueño"));
                empresa.setAmbito(rs.getString("ambito"));
                empresa.setTelefono(rs.getString("telefono"));
                empresa.setEmail(rs.getString("email"));
                empresa.setTutor(rs.getString("tutor"));
                empresa.setTelefono_contacto(rs.getString("telefono_contacto"));
                empresa.setNombre_contacto(rs.getString("nombre_contacto"));
                empresa.setEmail_contacto(rs.getString("email_contacto")); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empresa;
    }

    List<Centro> obtenerListaCentros(String query) {
        Centro centro;
        List<Centro> centros = null;
        try {
            Connection con = conectar();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            centros = new ArrayList<>();
            while (rs.next()) {
                centro = new Centro();

                centro.setId(rs.getInt("id"));
                centro.setNombre(rs.getString("nombre"));
                centro.setEmail(rs.getString("email"));
                centro.setTelefono(rs.getString("telefono"));
                centro.setDireccion(rs.getString("direccion"));
                centro.setId_tutor(rs.getInt("id_tutor"));

                centros.add(centro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return centros;

    }

    List<Convenio> obtenerListaConvenios(String query) {
        Convenio convenio;
        List<Convenio> convenios = null;
        try {
            Connection con = conectar();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            convenios = new ArrayList<>();
            while (rs.next()) {
                convenio = new Convenio();
                convenio.setId(rs.getInt("id"));
                convenio.setIdEmpresa(rs.getInt("id_empresa"));
                convenio.setAnexo2_1(rs.getBytes("anexo2.1"));
                convenio.setAnexo1(rs.getBytes("anexo1"));
                convenios.add(convenio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return convenios;
    }

    public int agregarCentro(String nombre, String email, String telefono, String direccion, String id_tutor) {
        int filasMod = 0;
        try {
            Connection con = conectar();
            String query = "INSERT INTO centro(nombre, email, telefono, direccion, id_tutor) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, direccion);
            preparedStatement.setInt(5, Integer.parseInt(id_tutor));

            filasMod = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasMod;
    }

    void borrarCentro(int idABorrar) {
        Connection con;
        try {
            con = conectar();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE centro SET eliminado = TRUE WHERE id = " + idABorrar + ";");
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int agregarTutor(String nombre, String apellidos, String telefono, String email) {
        int filasMod = 0;
        try {
            Connection con = conectar();
            String query = "INSERT INTO tutor_centro(nombre, apellidos, telefono, email) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellidos);
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, email);

            filasMod = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasMod;
    }

    void borrarTutor(int idABorrar) {
        Connection con;
        try {
            con = conectar();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE tutor_centro SET eliminado = TRUE WHERE id = " + idABorrar + ";");
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Tutor obtenerTutor(int idEscogido) {
        Tutor tutor = new Tutor();
        try {
            Connection con = conectar();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tutor_centro where id = " + idEscogido + "");
            if (rs.next()) {
                tutor.setId(rs.getInt("id"));
                tutor.setNombre(rs.getString("nombre"));
                tutor.setApellidos(rs.getString("apellidos"));
                tutor.setTelefono(rs.getString("telefono"));
                tutor.setEmail(rs.getString("email"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tutor;
    }

    /**
     *
     *
     */
    /*
     
      public int agregarConvenio(Empresa empresaSeleccionada, FileInputStream anexo2, Centro centroSelecionado, FileInputStream anexo1) {
        int filasMod = 0;
        try {
            Connection con = conectar();
            String query = "INSERT INTO convenio(id_empresa, anexo2.1, id_centro, anexo1 ) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, empresaSeleccionada.getId());
            preparedStatement.setBinaryStream(2, anexo2);
            preparedStatement.setInt(3, centroSelecionado.getId());
            preparedStatement.setBinaryStream(4, anexo1);
            
            filasMod = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasMod;
    }
     
     
     
     */
    // Me sale un error 
    public Centro obtenerCentro(int idEscogido) {
        Centro centro = null;

        try {
            Connection con = conectar();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from centro where id = " + idEscogido + "");
            if (rs.next()) {
                centro.setId(rs.getInt("id"));
                centro.setNombre(rs.getString("nombre"));
                centro.setEmail(rs.getString("email"));
                centro.setTelefono(rs.getString("telefono"));
                centro.setDireccion(rs.getString("direccion"));
                centro.setId_tutor(rs.getInt("id_tutor"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return centro;
    }

    public Object[] cargarComboTutores() {

        ArrayList<Item> tutores = new ArrayList<>();

        Statement statement = null;
        ResultSet registro = null;
        Connection con = null;
        try {
            con = conectar();
            statement = con.createStatement();
            String query = "Select id,nombre,apellidos "
                    + "from tutor_centro "
                    + "order by id";

            // libros
            // que
            // tenemos en nuestra
            // base de datos
            registro = statement.executeQuery(query);

            while (registro.next()) {
                Item item = new Item();
                item.setNombreMostradoEnElCombo(registro.getString("nombre") + " " + registro.getString("apellidos"));
                item.setIdEnLaTabla(registro.getInt("id"));
                tutores.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error al cerrar.\n");
            } catch (NullPointerException e) {

            }
        }

        return tutores.toArray();

    }
}
