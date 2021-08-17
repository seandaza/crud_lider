package com.utp.p46.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


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

    public void buscar_lider(String documento_identidad){
        try {
            //Consulta sql vulnerable a Sql injection
            /*
            String query = "SELECT * FROM lider WHERE Documento_identidad = \""+documento_identidad+"\"";
            System.out.println(query);
            Statement statement = this.conn.createStatement();
            //Ejecutamos el query
            ResultSet resultado = statement.executeQuery(query);
            */
            //query
            String query = "SELECT * FROM lider WHERE Documento_identidad =  ?";
            //Preparamos el query para su ejecucion
            PreparedStatement pStatement = this.conn.prepareStatement(query);
            //Anadimos valores al query
            pStatement.setString(1, documento_identidad);
            //Ejecutar y obtener los resultados de la consulta
            ResultSet resultado = pStatement.executeQuery();


            if(resultado.next()){
                System.out.println(resultado.getString("Nombre"));
            }
            
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
    }
}
