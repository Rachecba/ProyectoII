
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
    }

    public void debit(double amount) {
        double aux=availableBalance -= amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    
    
}
