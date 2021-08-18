package com.utp.p46.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.utp.p46.modelo.Lider;
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

            //Verificamos que haya almenos un registro como respuesta
            if(resultado.next()){
                //Crear el objeto
                Lider objLider = new Lider();
                //Pasar datos de la BD al objeto
                objLider.setId(resultado.getInt("ID_Lider"));
                objLider.setNombre(resultado.getString("Nombre"));
                objLider.setPrimer_apellido(resultado.getString("Primer_Apellido"));
                objLider.setSegundo_apellido(resultado.getString("Segundo_Apellido"));
                objLider.setSalario(resultado.getInt("Salario"));
                objLider.setCiudad_residencia(resultado.getString("Ciudad_Residencia"));
                objLider.setCargo(resultado.getString("Cargo"));
                objLider.setClasificiacion(resultado.getInt("Clasificacion"));
                objLider.setDocumento_identidad(resultado.getString("Documento_Identidad"));
                objLider.setFecha_nacimiento(resultado.getString("Fecha_Nacimiento"));
                
                this.vista.mostrar_lider(objLider);
            }
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
    }

    public void insertar_lider(){
        Lider objLider = this.vista.crear_lider();
        //Consulta SQL
        String query = "INSERT INTO lider VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pStatement = this.conn.prepareStatement(query);
            pStatement.setInt(1, objLider.getId());
            pStatement.setString(2, objLider.getNombre());
            pStatement.setString(3, objLider.getPrimer_apellido());
            pStatement.setString(4, objLider.getSegundo_apellido());
            pStatement.setInt(5, objLider.getSalario());
            pStatement.setString(6, objLider.getCiudad_residencia());
            pStatement.setString(7, objLider.getCargo());
            pStatement.setInt(8, objLider.getClasificacion());
            pStatement.setString(9, objLider.getDocumento_identidad());
            pStatement.setString(10, objLider.getFecha_nacimiento());

            //Ejecutar query

            if (pStatement.executeUpdate() == 1){
                System.out.println("Lider registrado con exito!");
            }

        } catch (Exception e) {
            
            System.err.println(e);
        }
        
    }
}
 