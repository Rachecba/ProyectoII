/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.data;

import atm.accesoDB.Coneccion;
import atm.model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
    
/**
 *
 * @author Rachel
 */
public class AccountDAO {
    
    public AccountDAO(){}
    
    public void actualizarTotalBalance(double amount, int accountNumber){
        String sql2 = "UPDATE APP.PCUENTA SET \"TOTALBALANCE\" ="+ amount +"WHERE ACCOUNTNUMBER ="+ accountNumber;
        update(sql2);
    }
    
    public void actualizarAvailableBalance(double amount, int accountNumber){
        String sql2 = "UPDATE APP.PCUENTA SET \"AVAILABLEBALANCE\" ="+ amount +"WHERE ACCOUNTNUMBER ="+ accountNumber;
        update(sql2);
    }
    
    public void update(String consulta) {
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
        String sql = "Select * from APP.PCUENTA u where u.ACCOUNTNUMBER =" + userAccountNumber + "and u.PIN =" + userPIN;
        
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
    
    
    public Account loadAccount(Account account, int number) {
        
        String sql = "Select CUENTAID, ACCOUNTNUMBER, AVAILABLEBALANCE, TOTALBALANCE, ID_CLIENTE from APP.PCUENTA u where u.ACCOUNTNUMBER =" + number;        
        ResultSet rs2 = consulta(sql);
        
        try {
            while (rs2.next()) {
                 account = new Account(Integer.parseInt(rs2.getString(1)),Integer.parseInt(rs2.getString(2)), Double.parseDouble(rs2.getString(3)), Double.parseDouble(rs2.getString(4)), Integer.parseInt(rs2.getString(5)));
            }
        } catch (SQLException ex) {
            System.out.println("Errores al obtener los resultados:: " + ex);
        }
        
        return account;
        
    } 

    public ResultSet consulta(String consulta) {
        ResultSet rs = null;
        try {
            PreparedStatement ps = Coneccion.prepararStatament(consulta);
            rs = ps.executeQuery();
        } catch (Exception ex) {
            System.out.println("Error en consulta: " + ex.getMessage());
        }
        return rs;
    }
    
    
    
    
    
    
}
