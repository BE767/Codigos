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
import org.rocnic.dao.Equipos;
import org.rocnic.dao.service.Conexion;

/**
 *
 * @author Evelyn
 */
public class EquiposService extends Conexion<Equipos> {

    public List<Equipos> getEquiposList() {
        List<Equipos> equiposList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Equipos equipo = null;

        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("SELECT * FROM equipos");
            if (resultSet == null) {
                return null;
            }
            equiposList = new ArrayList<>();
            while (resultSet.next()) {
                equipo = new Equipos();
                equipo.setIdEquipo(resultSet.getInt(1));
                equipo.setIdLaboratorio(resultSet.getInt(2));
                equipo.setIdPeriferico(resultSet.getInt(3));
                equipo.setNombreEquipo(resultSet.getString(4));
                equiposList.add(equipo);
            }
            resultSet.close();
            closeConnection(connection);
            return equiposList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return equiposList;
    }

    public boolean addEquipos(Equipos equipo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO equipos (IdLaboratorio, IdPeriferico, NombreEquipo) VALUES (?, ?, ?)";
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
            preparedStatement.setInt(1, equipo.getIdLaboratorio());
            preparedStatement.setInt(2, equipo.getIdPeriferico());
            preparedStatement.setString(3, equipo.getNombreEquipo());
            row = preparedStatement.executeUpdate();

            closeConnection(connection);
            return row == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return row < 0;
    }

    public boolean updateEquipos(Equipos equipo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE equipos SET NombreEquipo=?, IdPeriferico=? WHERE IdEquipo=?";
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
            preparedStatement.setString(1, equipo.getNombreEquipo());
            preparedStatement.setInt(2, equipo.getIdPeriferico());
            preparedStatement.setInt(3, equipo.getIdEquipo());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Equipos getEquiposByIdEquipo(int idEquipo) {
        Equipos equipo = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM equipos WHERE IdEquipo = ?");
            if (preparedStatement == null) {
                return null;
            }
            preparedStatement.setInt(1, idEquipo);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }

            equipo = new Equipos();
            if (resultSet.next()) {
                equipo.setIdEquipo(resultSet.getInt("IdEquipo"));
                equipo.setIdLaboratorio(resultSet.getInt("IdLaboratorio"));
                equipo.setIdPeriferico(resultSet.getInt("IdPeriferico"));
                equipo.setNombreEquipo(resultSet.getString("NombreEquipo"));
            }
            resultSet.close();
            closeConnection(connection);
            return equipo;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean deleteEquipo(Equipos equipo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM equipos WHERE IdEquipo = ?";
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
            preparedStatement.setInt(1, equipo.getIdEquipo());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<Equipos> getEquiposById(int idEquipo) {
    List<Equipos> equipos = new ArrayList<>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    try {
        connection = getConnection();
        if (connection == null) {
            return equipos;
        }
        
        preparedStatement = connection.prepareStatement("SELECT * FROM equipos WHERE IdEquipo = ?");
        if (preparedStatement == null) {
            return equipos;
        }
        
        preparedStatement.setInt(1, idEquipo);
        resultSet = preparedStatement.executeQuery();
        if (resultSet == null) {
            return equipos;
        }

        while (resultSet.next()) {
            Equipos equipo = new Equipos();
            equipo.setIdEquipo(resultSet.getInt("IdEquipo"));
            equipo.setIdLaboratorio(resultSet.getInt("IdLaboratorio"));
            equipo.setIdPeriferico(resultSet.getInt("IdPeriferico"));
            equipo.setNombreEquipo(resultSet.getString("NombreEquipo"));
            
            equipos.add(equipo);
        }
        
        resultSet.close();
        closeConnection(connection);
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    
    return equipos;
}

    
    
    
}
