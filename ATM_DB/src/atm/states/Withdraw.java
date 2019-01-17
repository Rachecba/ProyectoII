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
public class Withdraw extends State{
    
    public Withdraw(AtmImpl context) {
        super(context);
    }
    
    @Override
    public boolean debit(int number, double amount){
        boolean result;
        Account account = context.getDao().loadAccount(number);
        if(account.getAvailableBalance() >= amount){
            account.debit(amount);
            result = true;
        }else{
            
            result = false;
        }
        context.setState(new Start(context));
        return result;
    }
    
    @Override
    public double[] getBalance(int number){
        Account account = context.getDao().loadAccount(number);
        double availableBalance = account.getAvailableBalance();
        double totalBalance = account.getTotalBalance();
        context.setState(new Start(context));
        
        return new double[]{availableBalance, totalBalance};
    }
    
}
