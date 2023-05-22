/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rocnic.dao.Service;

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
import org.rocnic.dao.TipoReporte;
import org.rocnic.dao.service.Conexion;


public class TipoReporteService   extends Conexion<TipoReporte>
{
    public List<TipoReporte> getTipoReporteList() {
        List<TipoReporte> TipoReporteList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        TipoReporte tipoReporte = null;

        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("SELECT * FROM tiporeporte");
            if (resultSet == null) {
                return null;
            }
            TipoReporteList = new ArrayList<>();
            while (resultSet.next()) {
                tipoReporte = new TipoReporte();
                tipoReporte.setIdTipoReporte(resultSet.getInt(1));
                tipoReporte.setNombreTipoReporte(resultSet.getString(2));
                tipoReporte.setFechaCreacion(resultSet.getDate(4));
                TipoReporteList.add(tipoReporte);
            }
            resultSet.close();
            closeConnection(connection);
            return TipoReporteList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return TipoReporteList;
    }

    public boolean addTipoReporte(TipoReporte tipoReporte) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO tiporeporte (NombreTipoReporte,FechaCreacion) VALUES(?,?)";
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
            preparedStatement.setString(1, tipoReporte.getNombreTipoReporte());
            preparedStatement.setDate(2, dateUtil2DateSql(tipoReporte.getFechaCreacion()));
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return row < 0;
    }

    
    
    public boolean updateTipoReporte(TipoReporte tipoReporte) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE tiporeporte SET NombreTipoReporte=?   WHERE IdTipoReporte=?";
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
            preparedStatement.setString(1, tipoReporte.getNombreTipoReporte());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    
    public TipoReporte getTipoReporteByTipoReporte(String IdTipoReporte) {
        TipoReporte aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM tiporeporte WHERE IdTipoReporte = ?");
            if (preparedStatement == null) {
                return null;
            }
            preparedStatement.setString(1, IdTipoReporte);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }

            aux = new TipoReporte();
            if (resultSet.next()) {
                aux.setIdTipoReporte(resultSet.getInt("IdTipoReporte"));
                aux.setNombreTipoReporte(resultSet.getString("NombreTipoReporte"));
                aux.setFechaCreacion(resultSet.getDate("FechaCreacion"));
            }
            resultSet.close();
            closeConnection(connection);
            return aux;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

  public boolean deleteTipoReporte(TipoReporte tipoReporte) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM tiporeporte WHERE IdTipoReporte = ?";
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
            preparedStatement.setInt(1, tipoReporte.getIdTipoReporte());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    
    
    
    
}
