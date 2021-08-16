package com.utp.p46.controlador;

import java.sql.Connection;

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
}
