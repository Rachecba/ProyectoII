
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
    
    public BankDatabaseImpl()
    {
        Coneccion conect = new Coneccion();
        conect.getConexion();
        
        String sql2 = "SELECT * FROM UNA.PCUENTA";
        ResultSet rs2 = consulta(conect,sql2);
        try {
            while (rs2.next()) {
                cuentasList.add(new Account(Integer.parseInt(rs2.getString(1)),Integer.parseInt(rs2.getString(2)),Integer.parseInt(rs2.getString(3)), Double.parseDouble(rs2.getString(4)), Double.parseDouble(rs2.getString(5))));
            }
        } catch (SQLException ex) {
            System.out.println("Errores al obtener los resultados");
        }
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
    
    @Override
    public boolean authenticateUser( int userAccountNumber, int userPIN )
    {
        Account userAccount = loadAccount(userAccountNumber);
        if ( userAccount != null )
            return userAccount.validatePIN( userPIN );
        else
            return false;
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