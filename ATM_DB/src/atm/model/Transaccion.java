/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.model;

import atm.data.*;
import java.sql.Timestamp;

/**
 *
 * @author tvkev
 */
public class Transaccion {
    private String hora;
    private int numero_ATM;
    private String tipo_Transaccion;
    private int id_cuenta;
    private int amount;
  /*PARA EL TIPO DE TRANSACCION ES 
    -0 PARA LOGIN 
    -1 PARA VIEW BALANCE 
    -2 PARA RETIRO 
    -3 PARA DEPOSITO
    -4 PARA LOGOUT*/
    public Transaccion() {
    }

    public Transaccion(String hora, int numero_ATM, String tipo_Transaccion, int id_cuenta, int amount) {
        this.hora = hora;
        this.numero_ATM = numero_ATM;
        this.tipo_Transaccion = tipo_Transaccion;
        this.id_cuenta = id_cuenta;
        this.amount = amount;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getNumero_ATM() {
        return numero_ATM;
    }

    public void setNumero_ATM(int numero_ATM) {
        this.numero_ATM = numero_ATM;
    }

    public String getTipo_Transaccion() {
        return tipo_Transaccion;
    }

    public void setTipo_Transaccion(String tipo_Transaccion) {
        this.tipo_Transaccion = tipo_Transaccion;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int id) {
        this.amount = id;
    }
     
}
