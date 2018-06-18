/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author marco
 */
public class Conexion 
{
    //varriable de conexion
    Connection conexion;
        
    //Retornara el resultado de la conexion
    public  boolean getConexion()
    {
       return crearConexion();
    }
    
    //Prepara la conexion y retorna el estado de esta
    public  boolean crearConexion()
    {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String user = "root";
        String pass = "111417";

        try
        {
            conexion = DriverManager.getConnection(url, user,pass);
            System.out.println("Conectado!!");

        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        
        return true;
        
    }
    
    //Ejecutara sentencias DML
    public  boolean ejecutarSQL(String sql)
    {
        if (getConexion())
        {
            try 
            {
                Statement sentencia = conexion.createStatement();
                sentencia.executeUpdate(sql);
                conexion.close();
            } 
            catch (SQLException ex) 
            {
                ex.printStackTrace();
                return false;
            }

           return true;
        }
        else
        {
            return false;
        }        
    }
    
    //Ejecutara solo sentencias Select
    public  ResultSet ejecutarSQLSelect(String sql)
    {
        if (getConexion())
        {
            ResultSet resultado;
            try 
            {
                Statement sentencia = conexion.createStatement();
                resultado = sentencia.executeQuery(sql);
            } 
            catch (SQLException ex) 
            {
                ex.printStackTrace();
                return null;
            }

           return resultado;
        }
        else
        {
            return null;
        }
    }
}
