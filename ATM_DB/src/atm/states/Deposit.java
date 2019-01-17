/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.states;

import atm.model.Account;
import atm.model.AtmImpl;

/**
 *
 * @author Rachel
 */
public class Deposit extends State{
    
    public Deposit(AtmImpl context) {
        super(context);
    }
    
    @Override
    public boolean credit(int number, double amount){
        Account account = context.getDao().loadAccount(number);
        account.credit(amount);
        
        return true;
    }
    
}
