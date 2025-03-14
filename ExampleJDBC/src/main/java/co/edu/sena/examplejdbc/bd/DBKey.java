/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import co.edu.sena.examplejdbc.model.Key;
import co.edu.sena.examplejdbc.utils.MessageUtils;
import com.google.protobuf.Message;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            String sql ="Update `key` set name, room, count, observation values(?,?,?,?)";
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
    
}
