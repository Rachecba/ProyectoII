/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import atm.data.BankDatabase;
import atm.data.BankDatabaseImpl;
import atm.model.Atm;
import atm.model.AtmImpl;
import atm.view.View;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 *
 * @author Rachel
 */
public class Main {
    static
    {
        InputStream inputStream = Main.class.getResourceAsStream("logging.properties");
        try
        {
            LogManager.getLogManager().readConfiguration(inputStream);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        BankDatabase dao = new BankDatabaseImpl();
        
        Atm atm;
        
        if ((args.length > 0) && ("-nogui".equals(args[0])))
        {
            Logger.getLogger(Main.class.getName()).config("Starting ATM using console user interface");
            
        }
        else
        {
            Logger.getLogger(Main.class.getName()).info("Starting ATM using Swing user interface");
            View swingATMView = new View();
            swingATMView.setVisible(true);
            swingATMView.inicio();
        }
    }
    
}
