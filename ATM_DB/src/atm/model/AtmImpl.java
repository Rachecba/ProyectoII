
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
    
    public AtmImpl(BankDatabase bd){
        this.dao = bd;
        this.authenticated = false;
        this.state= new Login(this);
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
        createTransaccion(0);
        return state.authenticateUser(account, pin);
    }

    @Override
    public boolean startTransaction(int type) {
        return state.startTransaction(type);
    }

    @Override
    public boolean credit(int account, double amount) {
        createTransaccion(2);
        return state.credit(account, amount);
    }

    @Override
    public boolean debit(int account, double amount) {
        createTransaccion(3);
        return state.debit(account, amount);
    }

    @Override
    public double[] getBalance(int account) {
        createTransaccion(1);
        return state.getBalance(account);
    }
    
    public void createTransaccion(int tipo){
        //capturar el ultimo id metido en la base y actualizarlo
        int aux = coneccion()+1;
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String hora="\'" + hourdateFormat.format(date)+"\'";
        Transaccion x = new Transaccion(hora,1, tipo,2,aux);// falta el id del cliente que es el 2
        
        
        
//        INSERT INTO UNA.PTRANSACCION (HORA, NUMERO_ATM, TIPO_TRANSACCION, ID_CUENTA, ID) 
//	VALUES ('2019-01-01 12:45:15.0', 2, 2, 2, 2);
        Coneccion conect = new Coneccion();
        conect.getConexion();
        String sql2 = "INSERT INTO UNA.PTRANSACCION (HORA, NUMERO_ATM, TIPO_TRANSACCION, ID_CUENTA, ID)"
                + "VALUES ("+x.getHora()+","+x.getNumero_ATM()+", "+x.getTipo_Transaccion()+","+1+","+x.getId()+")";
        insersion(conect,sql2);

    }
    public void insersion(Coneccion con,String consulta) {
        Statement st = null;
        try {
            st=con.crearStatement2();
            st.executeUpdate(consulta);
        } catch (Exception ex) {
            System.out.println("Error en update: " + ex.getMessage());
        }
        try {
            st.close();
        } catch (SQLException ex) {
        }
    }
    
    public int coneccion(){
        Coneccion conect = new Coneccion();
        conect.getConexion();
        
        String sql2 = "SELECT * FROM UNA.PTRANSACCION";
        ResultSet rs2 = consulta(conect,sql2);
        int cont=0;
        try {
            while (rs2.next()) {
                cont++;
            }
        } catch (SQLException ex) {
            System.out.println("Errores al obtener los resultados");
        }
       
        return cont;
    }
    
    public ResultSet consulta(Coneccion con,String consulta) {
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepararStatament(consulta);
            rs = ps.executeQuery();
            //System.out.println("consula hecha bien");
        } catch (Exception ex) {
            //ystem.out.println("Error en consulta: " + ex.getMessage());
        }
        return rs;
    }
    
}
