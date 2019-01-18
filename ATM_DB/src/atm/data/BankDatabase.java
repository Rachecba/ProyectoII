/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.data;

import atm.model.Account;

/**
 *
 * @author Rachel
 */
public interface BankDatabase {
    
    boolean authenticateUser(int account, int pin);
    Account loadAccount(int account);
    BankDatabaseService getService();
    Account getAccount();
}
