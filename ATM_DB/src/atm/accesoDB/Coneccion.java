/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.accesoDB;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tvkev
 */
public class Coneccion {

    private static Connection conn = null;
    private Connection con = null;

    public Connection getConexion() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ProyectoDB", "una", "una");
            System.out.println("Conexion realizada");
        } catch (Exception ex) {
            System.out.println("Error en conexion: " + ex.getMessage());
        }
        return con;
    }
    public PreparedStatement prepararStatament(String consulta){
        try {
            return con.prepareStatement(consulta);
        } catch (SQLException ex) {
        } 
        return null;
    }

    public static void setStaticConexion() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ProyectoDB", "una", "una");
            System.out.println("Conexion realizada");
        } catch (Exception ex) {
            System.out.println("Error en conexion: " + ex.getMessage());
        }
    }
    public static Statement crearStatement() throws SQLException {
        return conn.createStatement();
    }
    public Statement crearStatement2() throws SQLException{
        return con.createStatement();
    }  
}

