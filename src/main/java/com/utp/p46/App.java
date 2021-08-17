package com.utp.p46;

import com.utp.p46.controlador.Controlador;
import com.utp.p46.vista.Vista;

public class App 
{
    public static void main( String[] args )
    {
        Vista vista = new Vista();
        Controlador objControlador = new Controlador(vista);

        objControlador.conectar_bd();
        objControlador.buscar_lider("P12WmZ2");
    }
}
