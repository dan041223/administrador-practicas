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
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Alumno;
import modelo.Anexo22;
import modelo.Empresa;
import modelo.Practica;
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
                usuario.setFechaNacimiento(rs.getString("fecha_nacimiento"));
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

    public int modificarAlumno(int idAlumno, String nombre, String apellidos, String dni, String direccion, String email, String numSS, String telefono, String ciclo, byte[] cvActual, FileInputStream cvASubir) {
        Connection con;
        int filasMod = 0;
        try {
            con = conectar();
             // SQL para la actualización
            String sql = "UPDATE alumnos SET nombre=?, apellidos=?, dni=?, direccion=?, " +
                         "email=?, \"numSeguridadSocial\"=?, telefono=?, ciclo=?, curriculum=? WHERE id=?";

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
                if (cvActual==null) {
                    preparedStatement.setBinaryStream(9, cvASubir);
                }else{
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
            String sql = "UPDATE usuarios SET nombre='" + nombre + "', apellidos='" + apellidos + "', fecha_nacimiento='" + fecha_nacimiento + "', password='" + password + "', " +
                         "email='" + email + "', telefono='" + telefono + "', tipo_usuario='" + tipo_usuario + "' WHERE id=" + idUsuario + "";
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
                }else{
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
                empresa.setCif(rs.getInt("cif"));
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

    public Empresa obtenerEmpresa(int id) {
        Empresa empresa = new Empresa();
        try {
            Connection con = conectar();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from empresa where \"idEmpresa\" = " + id + "");
            if (rs.next()) {
                empresa.setId(rs.getInt("idEmpresa"));
                empresa.setNombre(rs.getString("nombre"));
                empresa.setCif(rs.getInt("cif"));
                empresa.setDuenio(rs.getString("dueño"));
                empresa.setEmail(rs.getString("email"));
                empresa.setTelefono(rs.getString("telefono"));
                empresa.setDireccion(rs.getString("direccion"));
                empresa.setAmbito(rs.getString("ambito"));
                empresa.setTutor(rs.getString("tutor"));
                empresa.setNombre_contacto(rs.getString("nombre_contacto"));
                empresa.setEmail_contacto(rs.getString("email_contacto"));
                empresa.setBuscando(rs.getBoolean("buscando"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empresa;
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM alumnos WHERE CAST(id AS TEXT) LIKE '%" + valorIntroducidoAlumnos
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
                empresa.setId(rs.getInt("idEmpresa"));
                empresa.setNombre(rs.getString("nombre"));
                empresa.setCif(rs.getInt("cif"));
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
    
    public List obtenerListaAnexo22(String query){
        Anexo22 anexo;
        List<Anexo22> anexos = null;
        try {
            Connection con = conectar();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            anexos = new ArrayList<>();
            while (rs.next()) {                
                anexo = new Anexo22();
                anexo.setId(rs.getInt("id"));
                anexo.setIdCentro(rs.getInt("id_centro"));
                anexo.setFamiliaProfesional(rs.getString("familia_profesional"));
                anexo.setCicloFormativo(rs.getString("ciclo_formativo"));
                anexo.setAnexo22(rs.getBytes("anexo22"));
                anexo.setEliminado(rs.getBoolean("eliminado"));

                anexos.add(anexo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return anexos;
    }
    
    void borrarAnexo(int idABorrar) {
        Connection con;
        try {
            con = conectar();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE anexo22 SET eliminado = TRUE WHERE id = " + idABorrar + ";");
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int agregarAnexo(String idCentro, String familiaProfesional, String ciclo, FileInputStream cvASubir) {
        int filasMod = 0;
        try {
            Connection con = conectar();
            String query = "INSERT INTO anexo22(id_centro, familia_profesional, ciclo_formativo, anexo22) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, idCentro);
            preparedStatement.setString(2, familiaProfesional);
            preparedStatement.setString(3, ciclo);
            preparedStatement.setBinaryStream(4, cvASubir);
            
            filasMod = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasMod;
    }
    
    List<Practica> obtenerListaPractica(String query) {
        Practica practica;
        List<Practica> practicas = null;
        try {
            Connection con = conectar();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            practicas = new ArrayList<>();
            while (rs.next()) {                
                practica = new Practica();
                practica.setId(rs.getInt("id"));
                practica.setFecha_inicio(rs.getString("fecha_inicio"));
                practica.setId_alumno(rs.getInt("id_alumno"));
                practica.setAnexo4(rs.getBytes("anexo4"));
                practica.setAnexo8(rs.getBytes("anexo8"));
                practica.setId_convenio(rs.getInt("id_convenio"));
                practica.setFecha_fin(rs.getString("direccion"));
                
                practicas.add(practica);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return practicas;
    }
    
    void borrarPractica(int idABorrar) {
        Connection con;
        try {
            con = conectar();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE practica SET eliminado = TRUE WHERE id = " + idABorrar + ";");
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int agregarPractica(String idAlumno, String idConvenio, FileInputStream cvASubir1, FileInputStream cvASubir2) {
        int filasMod = 0;
        try {
            Connection con = conectar();
            String query = "INSERT INTO practica (id_alumno, fecha_inicio, anexo4, anexo8, id_convenio, fecha_fin) VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            LocalDate fechaActual = LocalDate.now();
            LocalDate fecha90DiasDespues = fechaActual.plusDays(90);

            java.sql.Date fechaInicio = java.sql.Date.valueOf(fechaActual);
            java.sql.Date fechaFinal = java.sql.Date.valueOf(fecha90DiasDespues);
            //ERROR
            preparedStatement.setDate(1, fechaInicio);
            preparedStatement.setInt(2, Integer.parseInt(idAlumno));           
            preparedStatement.setBinaryStream(3, cvASubir1);
            preparedStatement.setBinaryStream(4, cvASubir2);
            preparedStatement.setInt(5, Integer.parseInt(idConvenio));
            preparedStatement.setDate(6, fechaFinal);
         
            
            filasMod = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasMod;
    }
}
