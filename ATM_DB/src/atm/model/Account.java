
package atm.model;

import atm.data.*;
import atm.accesoDB.Coneccion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rachel
 */

public class Account {
    private int id;
    private int accountNumber;
    private int pin; 
    private double availableBalance; 
    private double totalBalance; 

    public Account(int id, int accountNumber, int pin, double availableBalance, double totalBalance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.availableBalance = availableBalance;
        this.totalBalance = totalBalance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean validatePIN(int userPIN) {
        if (userPIN == pin) {
            return true;
        } else {
            return false;
        }
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void credit(double amount) {
        double aux=totalBalance += amount;
        actualizarTotalBalance(aux);
    }

    public void debit(double amount) {
        double aux=availableBalance -= amount;
        actualizarAvailableBalance(aux);
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    public void actualizarTotalBalance(double amount){
        Coneccion conect = new Coneccion();
        conect.getConexion();
        String sql2 = "UPDATE UNA.PCUENTA SET \"TOTALBALANCE\" ="+ amount +"WHERE ACCOUNTNUMBER ="+ accountNumber;
        consulta(conect,sql2);
    }
    public void actualizarAvailableBalance(double amount){
        Coneccion conect = new Coneccion();
        conect.getConexion();
        String sql2 = "UPDATE UNA.PCUENTA SET \"AVAILABLEBALANCE\" ="+ amount +"WHERE ACCOUNTNUMBER ="+ accountNumber;
        consulta(conect,sql2);
    }
    public void consulta(Coneccion con,String consulta) {
        Statement st = null;
        try {
            st=con.crearStatement2();
            st.executeUpdate(consulta);
        } catch (Exception ex) {
            System.out.println("Error en update: " + ex.getMessage());
        }
        try {
            st.close();
        } catch (SQLException ex) {
        }
    }
    
    
}
