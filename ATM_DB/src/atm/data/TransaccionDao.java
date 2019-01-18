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

/**
 *
 * @author Rachel
 */
public class TransaccionDao {
    
    public TransaccionDao(){}
    
    public void insert(Transaccion transaccion){
        Coneccion.setConexion();
        String sql = "Insert into UNA.PTRANSACCION values (" + transaccion.getHora() + ", " + transaccion.getNumero_ATM() + ", " + transaccion.getTipo_Transaccion()
                     + ", " + transaccion.getId_cuenta() + ")";
        
        Statement st = null;
        
        try {
            st=Coneccion.crearStatement();
            st.execute(sql);
        } catch (Exception ex) {
            System.out.println("Error autenticando usuario: " + ex.getMessage());
        }
        
        try {
            st.close();
        } catch (SQLException ex) {
        }
    }
}
