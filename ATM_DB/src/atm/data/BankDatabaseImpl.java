
package atm.data;

import atm.accesoDB.Coneccion;
import atm.model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rachel
 */
public class BankDatabaseImpl implements BankDatabase{
    Account account;
    BankDatabaseService service;
    
    public BankDatabaseImpl()
    {
        this.service = new BankDatabaseService();
    }
    
    @Override
    public boolean authenticateUser( int userAccountNumber, int userPIN )
    {
        return service.authenticateUser(userAccountNumber, userPIN);
    }

    @Override
    public Account loadAccount(int number) {
        account = service.loadAccount(this.account, number);
        return account;
    }

    @Override
    public BankDatabaseService getService(){
        return this.service;
    }

    @Override
    public Account getAccount() {
        return account;
    }
    
    
   
} 