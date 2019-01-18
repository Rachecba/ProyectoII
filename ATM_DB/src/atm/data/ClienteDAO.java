/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.data;

import atm.accesoDB.Coneccion;
import atm.model.Cliente;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rachel
 */
public class ClienteDAO {
    
    public ClienteDAO(){}
    
    public Cliente getCliente(int clientId){
        String sql = "Select * from UNA.PCLIENTE u where u.CLIENTID =" + clientId;
        
        Statement st = null;
        
        try {
            st=Coneccion.crearStatement();
            return (Cliente) st.executeQuery(sql);
        } catch (Exception ex) {
            System.out.println("Error buscando cliente: " + ex.getMessage());
        }
        
        try {
            st.close();
        } catch (SQLException ex) {
        }
        return null;
    }
}
