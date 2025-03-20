/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import co.edu.sena.examplejdbc.model.EmployeeType;
import co.edu.sena.examplejdbc.model.Key;
import co.edu.sena.examplejdbc.utils.MessageUtils;
import com.google.protobuf.Message;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class DBKey extends DBConnection{
    public void insert(Key key)
    {
        try {
            connect();
            String sql ="INSERT INTO `key` (name, room, count, observation) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, key.getName());
            preparedStatement.setString(2, key.getRoom());
            preparedStatement.setInt(3, key.getCount());
            preparedStatement.setString(4, key.getObservation());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al insertar llave" +
                                            e.getMessage());
        } finally {
            disconnect();
        }
    }
    public void update(Key key)
    {
        try {
            connect();
            String sql ="Update `key` set name = ?, room = ?, count = ?, observation = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, key.getName());
            preparedStatement.setString(2, key.getRoom());
            preparedStatement.setInt(3, key.getCount());
            preparedStatement.setString(4, key.getObservation());
            preparedStatement.setInt(5, key.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al actualizar llave" +
                                            e.getMessage());
        } finally {
            disconnect();
        }
    }
    public void delete(int id)
    {
        try {
            connect();
            String sql = "delete from `key` where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
        } catch (Exception e) {
            MessageUtils.showErrorMessage("Error al eliminar llave" + e.getMessage());
        }
        finally {
            disconnect();
        }
    }
    public List<Key> findALL()
    {
        List<Key> result = new ArrayList<>();
        try {
            connect();
            String sql = "select * from `key`";
            statament = connection.createStatement();
            ResultSet resultSet = statament.executeQuery(sql);
            
            while (resultSet.next()) {
                Key key = new Key();
                key.setId(resultSet.getInt("id"));
                key.setName(resultSet.getString("name"));
                key.setRoom(resultSet.getString("room"));
                key.setCount(resultSet.getInt("Count"));
                key.setName(resultSet.getString("observation"));
                result.add(key);
            }
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar llave" +
                                            e.getMessage());
        } finally {
            disconnect();
        }
        return result;
     }
    public Key findById(int id)
    {
        Key key = null;
       try {
           connect();
            String sql = "select * from `key` where id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
               key = new Key();
               key.setId(resultSet.getInt("id"));
               key.setName(resultSet.getString("name"));
               key.setRoom(resultSet.getString("room"));
               key.setCount(resultSet.getInt("count"));
               key.setObservation(resultSet.getString("observation"));
            }
            
            resultSet.close();
            preparedStatement.close();
            
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar llave" +
                                            e.getMessage());
        } finally {
            disconnect();
        }
        return key;
    }

    
}
