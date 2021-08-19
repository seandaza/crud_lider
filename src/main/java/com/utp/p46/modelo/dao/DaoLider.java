package com.utp.p46.modelo.dao;


import com.utp.p46.modelo.dao.DaoLider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.utp.p46.controlador.DatabaseController;
import com.utp.p46.modelo.vo.Lider;

public class DaoLider {

    public Lider buscar_lider(String documento_identidad){
        //Crear el objeto
        Lider objLider = new Lider();
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
            Connection conn = DatabaseController.conectar_bd();
            //Preparamos el query para su ejecucion
            PreparedStatement pStatement = conn.prepareStatement(query);
            //Anadimos valores al query
            pStatement.setString(1, documento_identidad);
            //Ejecutar y obtener los resultados de la consulta
            ResultSet resultado = pStatement.executeQuery();

            //Verificamos que haya almenos un registro como respuesta
            if(resultado.next()){
            
               
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
                
                
            }
            //Cerrar la conexion
            conn.close();
            pStatement.close();
            
        } catch (Exception e) {
            
            System.out.println(e);
        }  
        return objLider;
    }
    

    public void insertar_lider(Lider objLider){
        
        //Consulta SQL
        String query = "INSERT INTO lider VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = DatabaseController.conectar_bd();
            PreparedStatement pStatement = conn.prepareStatement(query);
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

            //Cerrar la conexion
            conn.close();
            pStatement.close();

        } catch (Exception e) {
            
            System.err.println(e);
        }
        
    }


    public void actualizar_lider(Lider objLider, int id){
        String query = "UPDATE lider SET ID_Lider = ?, Nombre = ?, Primer_Apellido = ?, Segundo_Apellido = ?, Salario = ?, Ciudad_Residencia = ?, Cargo = ?, Clasificacion = ?, Documento_Identidad = ?, Fecha_Nacimiento = ? WHERE ID_lider = ?";
      
        try {
            Connection conn = DatabaseController.conectar_bd();
            PreparedStatement pstStatement = conn.prepareStatement(query);
            //Pasar los  parametros al query
            pstStatement.setInt(1, objLider.getId());
            pstStatement.setString(2, objLider.getNombre());
            pstStatement.setString(3, objLider.getPrimer_apellido());
            pstStatement.setString(4, objLider.getSegundo_apellido());
            pstStatement.setInt(5, objLider.getSalario());
            pstStatement.setString(6, objLider.getCiudad_residencia());
            pstStatement.setString(7, objLider.getCargo());
            pstStatement.setInt(8, objLider.getClasificacion());
            pstStatement.setString(9, objLider.getDocumento_identidad());
            pstStatement.setString(10, objLider.getFecha_nacimiento());
            pstStatement.setInt(11, id);

            /**pstStatement.executeUpdate() -> Ejecuta el query.
             * se obtiene como respuesta:
             * 1 -> Ejecucion satisfactoria
             * 2 -> No se efectuo ningun registro
             * */
            if(pstStatement.executeUpdate() == 1) {
                System.out.println("Actualizacion Satisfatoria!");
            }else {
                System.out.println("Error al actualizar! ");
            }

            //Cerrar la Conexion
            conn.close();
            pstStatement.close();


        } catch (Exception e) {
            System.err.println(e);
        }

        

    }

}
