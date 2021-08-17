package com.utp.p46.controlador;

import java.sql.Connection;
import java.sql.DriverManager;

import com.utp.p46.vista.Vista;

public class Controlador {
    /***********
     * Atributos
     ***********/  
     private Connection conn;
     private Vista vista;

    /***********
     * Constructor
     ***********/

     public Controlador(Vista vista){
         this.vista = vista;
     }
    /***********
     * Metodos
     ***********/
    public void conectar_bd(){
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:ProyectosConstruccion.db");
            System.out.println("Conexion exitosa!");
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
    }
}
