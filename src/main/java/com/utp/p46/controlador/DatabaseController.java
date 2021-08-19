package com.utp.p46.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//Metodo que retorna una conexion a la BD
public class DatabaseController {
    public  static Connection conectar_bd() throws SQLException {
        
            return DriverManager.getConnection("jdbc:sqlite:ProyectosConstruccion.db");
    
    }
}
