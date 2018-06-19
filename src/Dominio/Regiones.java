/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Control.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.Region;

/**
 *
 * @author marco
 */
public class Regiones 
{
    Conexion con = new Conexion();
    
    public Region listaRegiones() throws SQLException
    {
        int idRegion=0;
        String nombreRegion="";

        
        //Leemos los datos del usuario (si existe)
        //Atencion con dejar un espacio despues de abrir las comillas
        //eso impide que la las instrucciones de la query queden pegadas
        String consulta = "select idregion" +
                            "	, region" +
                            " from region" +
                            " where vigente = 'S'";

        ResultSet resultado = con.ejecutarSQLSelect(consulta);
        
        if (resultado != null)
        {
            while(resultado.next()) 
            {
                // Obtenemos los datos
                idRegion = resultado.getInt("idregion");
                nombreRegion = resultado.getString("region");

            }
        }
        
        Region re  = new Region();
        re.setIdRegion(idRegion);
        re.setNombreRegion(nombreRegion);
        re.setVigente("S");
   
       
        return re;
    }
    
}
