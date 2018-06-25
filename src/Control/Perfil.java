/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author marco
 */
public class Perfil 
{
    private String nombre;
    private static Perfil perfil;

    // El constructor es privado, no permite que se genere un constructor por defecto.
    private Perfil(String nombre) 
    {
        this.nombre = nombre;
        System.out.println("Mi nombre es: " + this.nombre);
    }

    public static Perfil getSingletonInstance(String nombre) 
    {
        if (perfil == null){
            perfil = new Perfil(nombre);
        }
        else{
            System.out.println("No se puede crear el objeto " + nombre + " porque ya existe un objeto de la clase Perfil");
        }
        
        return perfil;
    }
}
