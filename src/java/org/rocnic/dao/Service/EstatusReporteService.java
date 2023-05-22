
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rocnic.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.rocnic.dao.EstatusReporte;
import org.rocnic.dao.service.Conexion;

import org.rocnic.dao.EstatusReporte;


/**
 *
 * @author gerdoc
 */
public class EstatusReporteService extends Conexion<EstatusReporte>
{
    public List<EstatusReporte> getEstatusReporteList() 
    {
        List<EstatusReporte> EstatusReporteList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        EstatusReporte estatusReporte = null;
        
        try 
        {
            connection = getConnection();
            if (connection == null) 
            {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("SELECT * FROM estatusreporte");
            if (resultSet == null) 
            {
                return null;
            }
            EstatusReporteList = new ArrayList<>();
            while (resultSet.next()) 
            {
                estatusReporte = new EstatusReporte();
                estatusReporte.setIdEstatusReporte(resultSet.getInt(1));
                estatusReporte.setNombreEstatus(resultSet.getString(2));
                EstatusReporteList.add(estatusReporte);
            }
            resultSet.close();
            closeConnection(connection);
            return EstatusReporteList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return EstatusReporteList;
    }
    


    public boolean addEstatusReporte( EstatusReporte estatusReporte )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO estatusreporte(IdEstatusReporte,NombreEstatus) VALUES(?,?)";
        int row = 0;
        try 
        {
            connection = getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setInt(1, estatusReporte.getIdEstatusReporte());
            preparedStatement.setString(2, estatusReporte.getNombreEstatus());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean updateEstatusReporte( EstatusReporte estatusReporte)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update estatusreporte SET NombreEstatus=? WHERE IdEstatusReporte = ?";
        int row = 0;
        try 
        {
            connection = getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setString(2, estatusReporte.getNombreEstatus());
            preparedStatement.setInt(1, estatusReporte.getIdEstatusReporte());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    
    
    
    public boolean deleteEstatusReporte( EstatusReporte estatusReporte )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM estatusreporte WHERE IdEstatusReporte = ?";
        int row = 0;
        try 
        {
            connection = getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setInt(1, estatusReporte.getIdEstatusReporte());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    
    
    
    public EstatusReporte getEstatusReporteByEstatusReporte( String rol) 
    {
        EstatusReporte aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try 
        {
            connection = getConnection();
            if (connection == null) 
            {
                return null;
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM estatusreporte WHERE IdEstatusReporte = ?" );
            if (preparedStatement == null) 
            {
                return null;
            }
            preparedStatement.setString(1, rol );
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) 
            {
                return null;
            }
            aux = new EstatusReporte ( );
            while (resultSet.next()) 
            {

                aux.setIdEstatusReporte(resultSet.getInt(1));
                aux.setNombreEstatus(resultSet.getString(2));
            }
            resultSet.close();
            closeConnection(connection);
            return aux;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
}
