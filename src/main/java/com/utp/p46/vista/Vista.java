package com.utp.p46.vista;

import com.utp.p46.modelo.Lider;

public class Vista {
    //Constructor

    public void menu(){

    }

    public void mostrar_lider(Lider lider){
        System.out.println("----------LIDER----------");
        System.out.println("Id: "+lider.getId());
        System.out.println("Nombre: "+lider.getNombre());
        System.out.println("Primer apellido: "+lider.getPrimer_apellido());
        System.out.println("Segundo apellido: "+lider.getSegundo_apellido());
        //...demas datos
    }
    

} 