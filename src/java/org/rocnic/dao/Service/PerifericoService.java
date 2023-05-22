/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rocnic.dao.service;

/**
 *
 * @author Evelyn
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.rocnic.dao.Periferico;
import org.rocnic.dao.service.Conexion;


public class PerifericoService extends Conexion<Periferico>
{
     public List<Periferico> getPerifericoList() {
        List<Periferico> PerifericoList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Periferico periferico = null;

        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("SELECT * FROM perifericos");
            if (resultSet == null) {
                return null;
            }
            PerifericoList = new ArrayList<>();
            while (resultSet.next()) {
                
                periferico = new Periferico();
                periferico.setIdPeriferico(resultSet.getInt(1));
                periferico.setNombrePeriferico(resultSet.getString(2));
                PerifericoList.add(periferico);
            }
            resultSet.close();
            closeConnection(connection);
            return PerifericoList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return PerifericoList;
    }
     
     
    public boolean addPeriferico(Periferico periferico) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    String sql = "INSERT INTO perifericos (NombrePerifericos) VALUES(?)";
    int row = 0;
    try {
        connection = getConnection();
        if (connection == null) {
            return false;
        }
        preparedStatement = connection.prepareStatement(sql);
        if (preparedStatement == null) {
            return false;
        }
        preparedStatement.setString(1, periferico.getNombrePeriferico());
        row = preparedStatement.executeUpdate();
        closeConnection(connection);
        return row == 1;
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return row < 0;
}
    
    
    
    
    
     
        public boolean updateUsuarios(Periferico periferico) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE perifericos SET NombrePerifericos=?  WHERE IdPeriferico=?";
        int row = 0;
        try {
            connection = getConnection();
            if (connection == null) {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if (preparedStatement == null) {
                return false;
            }
            preparedStatement.setString(1, periferico.getNombrePeriferico());
            preparedStatement.setInt(2, periferico.getIdPeriferico());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
     
        
     public Periferico getPerifericosByPerifericos(String IdPeriferico) {
        Periferico aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM perifericos WHERE IdPeriferico = ?");
            if (preparedStatement == null) {
                return null;
            }
            preparedStatement.setString(1, IdPeriferico);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }

            aux = new Periferico();
            if (resultSet.next()) {
                aux.setIdPeriferico(resultSet.getInt("IdPeriferico"));
                aux.setNombrePeriferico(resultSet.getString("NombrePerifericos"));
            }
            resultSet.close();
            closeConnection(connection);
            return aux;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
     
      public boolean deletePeriferico(Periferico periferico) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM perifericos WHERE IdPeriferico = ?";
        int row = 0;
        try {
            connection = getConnection();
            if (connection == null) {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if (preparedStatement == null) {
                return false;
            }
            preparedStatement.setInt(1, periferico.getIdPeriferico());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
      
      
      
            public boolean validarNombreExistente(String NombrePerifericos) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = getConnection();
            String query = "SELECT *  FROM perifericos WHERE NombrePerifericos = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, NombrePerifericos);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return false;
    }
 
}
