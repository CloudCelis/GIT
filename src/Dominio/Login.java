/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Control.Conexion;
import Modelo.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marco
 */
//Realiza la validacion del usuario
public class Login 
{
    Conexion con = new Conexion();
    
    public Usuario loginUsuario(String user, String passwd) throws SQLException
    {
        int idUsuario=0;
        String nombreUsuario="";
        String clave="";
        int tipo = 0;  //si el tipo es 1 es un usuario normal
        
        //Leemos los datos del usuario (si existe)
        //Atencion con dejar un espacio despues de abrir las comillas
        //eso impide que la las instrucciones de la query queden pegadas
        
        String consulta = "select idusuario" +
                        " , usuario" +
                        " , idperfil" +
                        " , perfil" +
                        " , rut" +
                        " , CONCAT(nombre1, ' ', apellido1, ' ', apellido2)" +
                        " from usuario us" +
                        " , usuario_has_perfil up" +
                        " , perfil per" +
                        " , usuario_has_datos_usu uda" +
                        " , datos_usu dus" +
                        " where us.usuario = '" + user + "'" +
                        " and us.password = sha1('" + passwd + "')" +
                        " and up.usuario_idusuario = us.idusuario" +
                        " and per.idperfil = perfil_idperfil" +
                        " and uda.usuario_idusuario = us.idusuario" +
                        " and dus.rut = uda.datos_usu_rut";

        ResultSet resultado = con.ejecutarSQLSelect(consulta);
        
        if (resultado != null)
        {
            while(resultado.next()) 
            {
                // Obtenemos los datos
                idUsuario = resultado.getInt("idusuario");
                nombreUsuario = resultado.getString("usuario");
                clave = resultado.getString("password");
                tipo ++;
            }
        }
        
        Usuario us = new Usuario();
        us.setIdUsuario(idUsuario);
        us.setNombre(nombreUsuario);
        us.setClave(clave);
        us.setTipo(tipo);
        
        return us;
    }
}
