/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author marco
 */
//Clase usuario, contendra los valores del usuario conectado
public class Usuario 
{
    private int idUsuario;
    private String nombre;
    private String clave;
    private int tipo;

    public Usuario() {
    }

    
    
    public Usuario(int idUsuario, String nombre, String clave, int tipo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.clave = clave;
        this.tipo = tipo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
