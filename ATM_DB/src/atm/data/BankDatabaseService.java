/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.data;

import atm.accesoDB.Coneccion;
import atm.model.Account;
import atm.model.Cliente;
import atm.model.Transaccion;

/**
 *
 * @author Rachel
 */
public class BankDatabaseService {
    
    ClienteDAO cliente;
    AccountDAO account;
    TransaccionDao transaccion;
    
    public BankDatabaseService(){
        Coneccion.setConexion(); //establece coneccion
        
        this.cliente = new ClienteDAO();
        this.account = new AccountDAO();
        this.transaccion = new TransaccionDao();
    }
    
    public void updateTotalBalance(double amount, int accountNumber){
        this.account.actualizarTotalBalance(amount, accountNumber);
    }
    
    public void updateAvailableBalance(double amount, int accountNumber){
        this.account.actualizarAvailableBalance(amount, accountNumber);
    }
    
    public boolean authenticateUser(int userAccountNumber, int userPIN){
        return this.account.authenticateUser(userAccountNumber, userPIN);
    }
    
    public Account loadAccount(Account account, int number){
        return this.account.loadAccount(account, number);
    }
    
    public Cliente getCliente(int clientId){
        return this.cliente.getCliente(clientId);
    }

    public void insert(int id, int terminalID, String balance, int amount) {
        this.transaccion.insert(id, terminalID, balance, amount);
    }
}
