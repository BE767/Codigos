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
import org.rocnic.dao.Usuarios;
import org.rocnic.dao.service.Conexion;

/**
 *
 * @author Evelyn
 */
public class UsuariosService extends Conexion<Usuarios> {

    public List<Usuarios> getUsuarioList() {
        List<Usuarios> UsuariosList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Usuarios usuarios = null;

        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("SELECT * FROM usuarios");
            if (resultSet == null) {
                return null;
            }
            UsuariosList = new ArrayList<>();
            while (resultSet.next()) {
                usuarios = new Usuarios();
                usuarios.setIdUsuario(resultSet.getInt(1));
                usuarios.setIdPerfil(resultSet.getInt(2));
                usuarios.setUsuario(resultSet.getString(3));
                usuarios.setContraseña(resultSet.getString(4));
                usuarios.setNombre(resultSet.getString(5));
                usuarios.setBoleta(resultSet.getString(6));
                UsuariosList.add(usuarios);
            }
            resultSet.close();
            closeConnection(connection);
            return UsuariosList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return UsuariosList;
    }

    public boolean addUsuarios(Usuarios usuario) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO usuarios (IdPerfil,Usuario,Contraseña,Nombre,Boleta) VALUES(?,?,?,?,?)";
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
            preparedStatement.setInt(1, usuario.getIdPerfil());
            preparedStatement.setString(2, usuario.getUsuario());
            preparedStatement.setString(3, usuario.getContraseña());
            preparedStatement.setString(4, usuario.getNombre());
            preparedStatement.setString(5, usuario.getBoleta());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return row < 0;
    }

    public boolean updateUsuarios(Usuarios usuario) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE usuarios SET IdPerfil=?, Usuario=?, Contraseña=?, Nombre=?, Boleta=? WHERE IdUsuario=?";
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
            preparedStatement.setInt(1, usuario.getIdPerfil());
            preparedStatement.setString(2, usuario.getUsuario());
            preparedStatement.setString(3, usuario.getContraseña());
            preparedStatement.setString(4, usuario.getNombre());
            preparedStatement.setString(5, usuario.getBoleta());
            preparedStatement.setInt(6, usuario.getIdUsuario());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Usuarios getUsuariosByUsuarios(String IdUsuario) {
        Usuarios aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM usuarios WHERE IdUsuario = ?");
            if (preparedStatement == null) {
                return null;
            }
            preparedStatement.setString(1, IdUsuario);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }

            aux = new Usuarios();
            if (resultSet.next()) {
                aux.setIdUsuario(resultSet.getInt("IdUsuario"));
                aux.setIdPerfil(resultSet.getInt("IdPerfil"));
                aux.setUsuario(resultSet.getString("Usuario"));
                aux.setContraseña(resultSet.getString("Contraseña"));
                aux.setNombre(resultSet.getString("Nombre"));
                aux.setBoleta(resultSet.getString("Boleta"));
            }
            resultSet.close();
            closeConnection(connection);
            return aux;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

  public boolean deleteUsuario(Usuarios usuario) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM usuarios WHERE IdUsuario = ?";
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
            preparedStatement.setInt(1, usuario.getIdUsuario());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
  
  
 
   

  

    public boolean validarUsuarioContraseñaBoletaExistente(String usuario, String contraseña, String boleta) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean existe = false;

        try {
            connection = getConnection(); // Obtener conexión a la base de datos

            String sql = "SELECT * FROM usuarios WHERE Usuario = ? OR Contraseña = ? OR Boleta = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, contraseña);
            preparedStatement.setString(3, boleta);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                existe = (count > 0);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return existe;
    }

  





}
