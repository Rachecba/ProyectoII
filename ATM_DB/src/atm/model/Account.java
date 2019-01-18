
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
    private int clientID;

    public Account(int id, int accountNumber, double availableBalance, double totalBalance, int clientID){
        this.id = id;
        this.accountNumber = accountNumber;
        this.availableBalance = availableBalance;
        this.totalBalance = totalBalance;
        this.clientID = clientID;
    }

    public Account() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        totalBalance = totalBalance += amount;
    }

    public void debit(double amount) {
        availableBalance = availableBalance -= amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    
    
}
