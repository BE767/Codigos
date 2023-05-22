/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rocnic.dao.Service;

import org.rocnic.dao.Laboratorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.rocnic.dao.service.Conexion;

/**
 *
 * @author Evelyn
 */
public class LaboratorioService extends Conexion<Laboratorio> {

    public List<Laboratorio> getLaboratorioList() {
        List<Laboratorio> LaboratorioList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Laboratorio laboratorio = null;

        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("SELECT * FROM laboratorio");
            if (resultSet == null) {
                return null;
            }
            LaboratorioList = new ArrayList<>();
            while (resultSet.next()) {
                laboratorio = new Laboratorio();
                laboratorio.setIdLaboratorio(resultSet.getInt(1));
                laboratorio.setNombreLaboratorio(resultSet.getString(2));
                laboratorio.setNumeroDeEquipo(resultSet.getInt(3));
                laboratorio.setIdPeriferico(resultSet.getInt(4));

                LaboratorioList.add(laboratorio);
            }
            resultSet.close();
            closeConnection(connection);
            return LaboratorioList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return LaboratorioList;
    }

    public boolean addUsuarios(Laboratorio laboratorio) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO laboratorio (NombreLaboratorio,NumeroDeEquipo,IdPeriferico) VALUES(?,?,?)";
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
            preparedStatement.setString(1, laboratorio.getNombreLaboratorio());
            preparedStatement.setInt(2, laboratorio.getNumeroDeEquipo());
            preparedStatement.setInt(2, laboratorio.getIdPeriferico());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return row < 0;
    }
    
    
    
        public boolean updateUsuarios(Laboratorio laboratorio) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE laboratorio SET NombreLaboratorio=?, NumeroDeEquipo=?, IdPeriferico=?,  WHERE IdUsuario=?";
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
            preparedStatement.setString(1, laboratorio.getNombreLaboratorio());
            preparedStatement.setInt(2, laboratorio.getNumeroDeEquipo());
            preparedStatement.setInt(3, laboratorio.getIdPeriferico());
            preparedStatement.setInt(4, laboratorio.getIdLaboratorio());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
        
       public Laboratorio getUsuariosByUsuarios(String IdLaboratorio) {
        Laboratorio aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM laboratorio WHERE IdLaboratorio = ?");
            if (preparedStatement == null) {
                return null;
            }
            preparedStatement.setString(1, IdLaboratorio);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }

            aux = new Laboratorio();
            if (resultSet.next()) {
                aux.setIdLaboratorio(resultSet.getInt("IdLaboratorio")); 
                aux.setNombreLaboratorio(resultSet.getString("NombreLaboratorio"));
                aux.setNumeroDeEquipo(resultSet.getInt("NumeroDeEquipo"));
                aux.setIdPeriferico(resultSet.getInt("IdPeriferico"));
            }
            resultSet.close();
            closeConnection(connection);
            return aux;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

  public boolean deleteUsuario(Laboratorio laboratorio) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM laboratorio WHERE IdLaboratorio = ?";
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
            preparedStatement.setInt(1, laboratorio.getIdLaboratorio());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
  
        
        
        
        

}
