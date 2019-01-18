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
public class Login extends State{
    
    public Login(AtmImpl context) {
        super(context);
    }
    
    @Override
    public boolean authenticateUser(int number, int pin){
        boolean result;
        if(context.getDao().authenticateUser(number, pin)){
            context.setAuthenticated(true);
            context.setState(new Start(context));
            context.getDao().getService().insert(context.getDao().loadAccount(number).getId(), context.getTerminalID(), "Login", 0);
            result = true;
        }else{
            result = false;
        }
        
        return result;
    }
    
   
}
