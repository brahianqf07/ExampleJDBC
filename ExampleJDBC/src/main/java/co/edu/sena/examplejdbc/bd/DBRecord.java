/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.Key;
import co.edu.sena.examplejdbc.model.Record;
import co.edu.sena.examplejdbc.utils.MessageUtils;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class DBRecord extends DBConnection {
    public void insert(Record record){
        try {
            connect();
            String sql = "INSERT INTO record (date_record, start_time, end_time, employee_id, key_id, status) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, record.getDateRecord());
            preparedStatement.setString(2, record.getStartTime());
            preparedStatement.setString(3, record.getEndTime()); 
            preparedStatement.setLong(4, record.getEmployee().getDocument());   //FK
            preparedStatement.setInt(5, record.getKey().getId());   //FK
            preparedStatement.setString(6, record.getStatus());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
             MessageUtils.showErrorMessage("Error al insertar registro " +
                    e.getMessage());
        } finally {
            disconnect();
        }
    }
    public void update(Record record) {
        try {
            connect();
            String sql = "update record set  date_record = ?, start_time = ?, end_time = ?, employee_id = ?, key_id = ?, "
                    + "status = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,record.getDateRecord());
            preparedStatement.setString(2,record.getStartTime());
            preparedStatement.setString(3,record.getEndTime());
            preparedStatement.setLong(4,record.getEmployee().getDocument());
            preparedStatement.setInt(5, record.getKey().getId());
            preparedStatement.setString(6,record.getStatus());
            preparedStatement.setInt(7,record.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al actualizar registro " + e.getMessage());
        } finally {
            disconnect();
        }
    }
     
     public void delete(int id) {
        try {
            connect();
            String sql = "delete from record where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
              } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al eliminar registro " + e.getMessage());
        } finally {
            disconnect();
        }
    }
               
     
    public List<Record> findAll() {
        List<Record> records = new ArrayList<>();
        DBEmployee dbe  = new DBEmployee();
        DBKey dbk = new DBKey();
        try {
            connect();
            String sql = "select * from record";
            statament = connection.createStatement();
            ResultSet resultSet = statament.executeQuery(sql);
            while (resultSet.next()) {
                Record record = new Record();
                record.setId(resultSet.getInt("id"));
                record.setDateRecord(resultSet.getString("date_record"));
                record.setStartTime(resultSet.getString("start_time"));
                record.setEndTime(resultSet.getString("end_time"));
                record.setStatus(resultSet.getString("status"));
                //FK de employee
                Employee employee = dbe.findByid(resultSet.getLong( "employee_id"));
                record.setEmployee(employee);
                //FK de key
                Key key = dbk.findById(resultSet.getInt("key_id"));
                record.setKey(key);
                records.add(record);
            }
              } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar registro" + e.getMessage());
        } finally {
            disconnect();
        }
        return records;

    }
    
    public Record findById(int id) {
        Record record = null;
        DBEmployee dbe = new DBEmployee();
        DBKey dbk = new DBKey();

        try {
            connect();
            String sql = "select * from record where id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                record= new Record();
                record.setId(resultSet.getInt("id"));
                record.setDateRecord(resultSet.getString("date_record"));
                record.setStartTime(resultSet.getString("start_time"));
                record.setEndTime(resultSet.getString("end_time"));
                record.setStatus(resultSet.getString("status"));
                //FK
                Employee employee = dbe.findByid(resultSet.getInt("employee_id"));
                record.setEmployee(employee);
                //FK de key
                Key key = dbk.findById(resultSet.getInt("key_id"));
                record.setKey(key);
                
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar empleado" + e.getMessage());
        } finally {
            disconnect();
        }
        return record;
    }
    
}
