/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.states;

import atm.model.AtmImpl;

/**
 *
 * @author Rachel
 */
public class Start extends State{
    
    private final int BALANCE_INQUIRY = 1;
    private final int WITHDRAWAL = 2;
    private final int DEPOSIT = 3;
    private final int EXIT = 4;
    
    public Start(AtmImpl context) {
        super(context);
    }
    
    @Override 
    public boolean startTransaction(int type){
        boolean result = true;
        
        switch(type){
            case BALANCE_INQUIRY:
                context.setState(new Balance(context));
                break;
            case WITHDRAWAL:
                context.setState(new Withdraw(context));
                break;
            case DEPOSIT:
                context.setState(new Deposit(context));
                break;
            case EXIT:
                context.setState(new Login(context));
                break;
            default:
                result = false;
        }
        
        return result;
    }
    
}
