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
import org.rocnic.dao.TipoError;
import org.rocnic.dao.service.Conexion;

public class TipoErrorService extends Conexion<TipoError> {

    public List<TipoError> getTipoErrorList() {
        List<TipoError> TipoErrorList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        TipoError tipoError = null;

        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("SELECT * FROM tipoerror");
            if (resultSet == null) {
                return null;
            }
            TipoErrorList = new ArrayList<>();
            while (resultSet.next()) {
                tipoError = new TipoError();
                tipoError.setIdTipoError(resultSet.getInt(1));
                tipoError.setNombreError(resultSet.getString(2));
                tipoError.setIdTipoReporte(resultSet.getInt(3));

                TipoErrorList.add(tipoError);
            }
            resultSet.close();
            closeConnection(connection);
            return TipoErrorList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return TipoErrorList;
    }

    public boolean addUsuarios(TipoError tipoError) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO tipoerror (NombreError,IdTipoReporte) VALUES(?,?)";
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
            preparedStatement.setString(1, tipoError.getNombreError());
            preparedStatement.setInt(2, tipoError.getIdTipoReporte());

            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return row < 0;
    }

    public boolean updateUsuarios(TipoError tipoError) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE tipoerror SET NombreError=?, WHERE IdTipoError=?";
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
            preparedStatement.setString(1, tipoError.getNombreError());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public TipoError  getTipoErrorByTipoError(String IdTipoError ) {
        TipoError aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM tipoerror WHERE IdTipoError = ?");
            if (preparedStatement == null) {
                return null;
            }
            preparedStatement.setString(1, IdTipoError);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }

            aux = new TipoError();
            if (resultSet.next()) {
                aux.setIdTipoError(resultSet.getInt("IdTipoError"));
                aux.setIdTipoReporte(resultSet.getInt("IdTipoReporte"));
                aux.setNombreError(resultSet.getString("NombreError"));
            }
            resultSet.close();
            closeConnection(connection);
            return aux;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean deleteUsuario(TipoError tipoError) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM tipoerror WHERE IdTipoError = ?";
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
            preparedStatement.setInt(1, tipoError.getIdTipoError());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
