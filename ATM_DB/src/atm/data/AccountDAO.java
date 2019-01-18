/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.data;

import atm.accesoDB.Coneccion;
import atm.model.Account;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rachel
 */
public class AccountDAO {
    
    public AccountDAO(){}
    
    public void actualizarTotalBalance(double amount, int accountNumber){
        Coneccion.setConexion();
        String sql2 = "UPDATE UNA.PCUENTA SET \"TOTALBALANCE\" ="+ amount +"WHERE ACCOUNTNUMBER ="+ accountNumber;
        consulta(sql2);
    }
    
    public void actualizarAvailableBalance(double amount, int accountNumber){
        Coneccion.setConexion();
        String sql2 = "UPDATE UNA.PCUENTA SET \"AVAILABLEBALANCE\" ="+ amount +"WHERE ACCOUNTNUMBER ="+ accountNumber;
        consulta(sql2);
    }
    
    public void consulta(String consulta) {
        Statement st = null;
        
        try {
            st=Coneccion.crearStatement();
            st.executeUpdate(consulta);
        } catch (Exception ex) {
            System.out.println("Error en update: " + ex.getMessage());
        }
        
        try {
            st.close();
        } catch (SQLException ex) {
        }
    }
    
    public boolean authenticateUser( int userAccountNumber, int userPIN )
    {
        Coneccion.setConexion();
        String sql = "Select * from UNA.PCUENTA u where u.ACCOUNTNUMBER =" + userAccountNumber + "and u.PIN =" + userPIN;
        
        Statement st = null;
        
        try {
            st=Coneccion.crearStatement();
            st.executeQuery(sql);
            return true;          
        } catch (Exception ex) {
            System.out.println("Error autenticando usuario: " + ex.getMessage());
        }
        
        try {
            st.close();
        } catch (SQLException ex) {
        }
        
        return false;
    }
    
    
    public Account loadAccount(int number) {
        Coneccion.setConexion();
        String sql = "Select ID, ACCOUNTNUMBER, AVAILABLEBALANCE, TOTALBALANCE from UNA.PCUENTA u where u.ACCOUNTNUMBER =" + number;
        
        Statement st = null;
        
        try {
            st=Coneccion.crearStatement();
            return (Account) st.getResultSet();
            
        } catch (Exception ex) {
            System.out.println("Error buscando cuenta " + ex.getMessage());
        }
        
        try {
            st.close();
        } catch (SQLException ex) {
        }
        
        return null;
    } 

}
