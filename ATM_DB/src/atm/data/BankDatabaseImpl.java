
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
    ArrayList<Account> cuentasList = new ArrayList<>();
    BankDatabaseService service;
    
    public BankDatabaseImpl()
    {
    }
    
    
    
    @Override
    public boolean authenticateUser( int userAccountNumber, int userPIN )
    {
//        Account userAccount = loadAccount(userAccountNumber);
//        if ( userAccount != null )
//            return userAccount.validatePIN( userPIN );
//        else
//            return false;
        
        //despues de autenticar de una vez guarda la cuenta.
    }

    @Override
    public Account loadAccount(int number) {
        for(Account account : cuentasList){
            if(account.getAccountNumber() == number)
                return account;
        }
        return null;
    }

    @Override
    public boolean saveAccount(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
} 