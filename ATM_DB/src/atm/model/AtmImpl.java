
package atm.model;

import atm.accesoDB.Coneccion;
import atm.data.BankDatabase;
import atm.model.Transaccion;
import atm.states.Login;
import atm.states.Start;
import atm.states.State;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Rachel
 */
public class AtmImpl implements Atm {
    State state;
    BankDatabase dao;
    boolean authenticated;
    int terminalID;
    
    public AtmImpl(BankDatabase bd){
        this.dao = bd;
        this.authenticated = false;
        this.state= new Login(this);
        
        this.terminalID = (int) (Math.random() * 100) + 1;
    }
    
    public boolean getAuthenticated(){
        return this.authenticated;
    }
    
    public void setAuthenticated(boolean authenticated){
        this.authenticated = authenticated;
    }
    
    public State getState(){
        return this.state;
    }
    
    public void setState(State state){
        this.state = state;
    }
    
    public BankDatabase getDao(){
        return this.dao;
    }
    
    public void setDao(BankDatabase dao){
        this.dao = dao;
    }
    
    @Override
    public boolean authenticateUser(int account, int pin) {
        return state.authenticateUser(account, pin);
    }

    @Override
    public boolean startTransaction(int type) {
        return state.startTransaction(type);
    }

    @Override
    public boolean credit(int account, double amount) {
        return state.credit(account, amount);
    }

    @Override
    public boolean debit(int account, double amount) {
        return state.debit(account, amount);
    }

    @Override
    public double[] getBalance(int account) {
        return state.getBalance(account);
    }
   
    public int getTerminalID(){
        return this.terminalID;
    }
    
}
