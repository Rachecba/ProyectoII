
package atm.model;

import java.util.function.Consumer;

/**
 *
 * @author Rachel
 */
public interface Atm {
    
    boolean authenticateUser(int account, int pin);
    boolean startTransaction(int type);
    boolean credit(int account, double amount);
    boolean debit(int account, double amount);
    double[] getBalance(int account);
}
