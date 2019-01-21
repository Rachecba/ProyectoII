/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.data;

import atm.accesoDB.Coneccion;
import atm.model.Transaccion;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Rachel
 */
public class TransaccionDao {
    
    public TransaccionDao(){}
    
    public void insert(int id, int terminalID, String balance, double amount){
        System.out.println("entra");
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String hora="" + hourdateFormat.format(date);
        
        Transaccion transaccion = new Transaccion(hora, terminalID, balance, id, amount);        
//        INSERT INTO APP.PTRANSACCION (ACCOUNTID, TERMINALID, TRANSACTIONTYPE, AMOUNT, TIMESTAMP) 
//	VALUES (1,1,'Login',0,'1970-01-01 00:00:00');
        String sql = "Insert into APP.PTRANSACCION (ACCOUNTID, TERMINALID, TRANSACTIONTYPE, AMOUNT, TIMESTAMP) "
                + " values ("+transaccion.getId_cuenta()+","+transaccion.getNumero_ATM() +","+"'"+transaccion.getTipo_Transaccion()+"'"+","
                +transaccion.getAmount()+","+"'"+transaccion.getHora()+"')";
        
        Statement st = null;
        
        try {
            st=Coneccion.crearStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("Error autenticando usuario: " + ex.getMessage());
        }
        
        try {
            st.close();
        } catch (SQLException ex) {
        }
    }
}
