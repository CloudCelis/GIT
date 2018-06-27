/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class Conexion 
{
    //varriable de conexion
    Connection conn;
        
    //Retornara el resultado de la conexion
    public  boolean getConexion() throws SQLException, ClassNotFoundException
    {
        try
        {
            conn = Servicios.Conexion.obtener();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        
        return true;
    }

    
    //Ejecutara sentencias DML
    public  boolean ejecutarSQL(String sql) throws SQLException
    {
        try {
            if (getConexion()) 
            {
                try
                {
                    Statement sentencia = conn.createStatement();
                    sentencia.executeUpdate(sql);
                    conn.close(); 
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    //Ejecutara solo sentencias Select
    public  ResultSet ejecutarSQLSelect(String sql) throws SQLException
    {
        ResultSet resultado;
        
        try {
            if (getConexion()) 
            {
                
                try
                {
                    Statement sentencia = conn.createStatement(); 
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
