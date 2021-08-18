package com.utp.p46.vista;

import java.util.Scanner;

import com.utp.p46.controlador.Controlador;
import com.utp.p46.modelo.Lider;

public class Vista {
    //Atributo
    private Controlador objControlador;

    //Constructor
    public Vista(){
        this.objControlador = new Controlador();
    }

    public void menu(){  

    }

    public void buscar_lider(){
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.println("Ingrese el documento del lider que desea consultar");
            String documento = entrada.next();

            this.mostrar_lider(this.objControlador.buscar_lider(documento));
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
 
    public void mostrar_lider(Lider lider){
        System.out.println("--------------------LIDER------------------------");
        System.out.println("");
        System.out.println("Id: "+lider.getId());
        System.out.println("Nombre: "+lider.getNombre());
        System.out.println("Primer apellido: "+lider.getPrimer_apellido());
        System.out.println("Segundo apellido: "+lider.getSegundo_apellido());
        System.out.println("Salario: "+lider.getSalario());
        System.out.println("Ciudad residencia: "+lider.getCiudad_residencia());
        System.out.println("Cargo: "+lider.getCargo());
        System.out.println("Clasificacion: "+lider.getClasificacion());
        System.out.println("Documento identidad: "+ lider.getDocumento_identidad());
        System.out.println("Fecha Nacimiento: "+ lider.getFecha_nacimiento());
        System.out.println("");
        System.out.println("---------------------------------------------------");
        
    }
    
    public void crear_formulario(){
        
        try 
           ( Scanner entrada = new Scanner(System.in)){

            System.out.println("Ingrese el id: ");
            int id = entrada.nextInt();

            System.out.println("Ingrese el nombre: ");
            String nombre = entrada.next();

            System.out.println("Ingrese el primer apellido: ");
            String pApellido = entrada.next();

            System.out.println("Ingrese el segundo apellido: ");
            String sApellido = entrada.next();
   
            System.out.println("Ingrese el salario: ");
            int salario = entrada.nextInt();

            System.out.println("Ingrese la Ciudad de Residencia: ");
            String ciudad = entrada.next();

            System.out.println("Ingrese el Cargo: ");
            String cargo = entrada.next();

            System.out.println("Ingrese la Clasificacion: ");
            int clasificacion = entrada.nextInt();

            System.out.println("Ingrese el Documento de identidad: ");
            String documento = entrada.next();

            System.out.println("Ingrese Fecha de Nacimiento (yyyy-mm-dd): ");
            String fecha_nacimiento = entrada.next();

            this.objControlador.insertar_lider(this.objControlador.built_lider(id, nombre, primer_apellido, segundo_apellido, salario, ciudad_residencia, cargo, clasificacion, documento_identidad, fecha_nacimiento));


           }
         catch (Exception e) {
            
        }
        return objLider;
    }

    public void actualizar_lider(){
        try (Scanner entrada = new Scanner(System.in)) {

        System.out.println("Ingrese la cedula del lider a actualizar: ");
        String documento_identidad = entrada.next();
        Lider objLider = this.objControlador.buscar_lider(documento_identidad);

        System.out.println("-------------DATOS DEL LIDER A ACTUALIZAR---------------");
        this.mostrar_lider(objLider);

            
        } catch (Exception e) {
    
        }
    }
    

} 