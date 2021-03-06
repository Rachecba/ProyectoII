
package atm.states;

import atm.model.Account;
import atm.model.AtmImpl;

/**
 *
 * @author Rachel
 */
public class Balance extends State{
    
    public Balance(AtmImpl context) {
        super(context);
    }
    
    @Override
    public double[] getBalance(int number){
        Account account = context.getDao().loadAccount(number);
        double availableBalance = account.getAvailableBalance();
        double totalBalance = account.getTotalBalance();
        context.setState(new Start(context));
        
        context.getDao().getService().insert(account.getId(), context.getTerminalID(), "Balance", 0);
        
        return new double[]{availableBalance, totalBalance};
    }
    
}
