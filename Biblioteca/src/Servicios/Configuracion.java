/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

/**
 *
 * @author mcelis
 */
public class Configuracion 
{
    private int perfil;
    private static Configuracion configuracion;

    // El constructor es privado, no permite que se genere un constructor por defecto.
    private Configuracion(int vPerfil) 
    {
        this.perfil = vPerfil;
    }

    public static Configuracion getSingletonInstance(int vPerfil) 
    {
        if (configuracion == null)
        {
            configuracion = new Configuracion(vPerfil);
        }
        else
        {
            System.out.println("No se puede crear el objeto porque ya existe un objeto de la clase Configuracion");
        }
        
        return configuracion;
    }
     
     public void setLogout()
     {
         this.perfil = Integer.parseInt(null);
     }
     
}
