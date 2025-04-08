/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import co.edu.sena.examplejdbc.utils.MessageUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *Fecha: 13/03/2025
 * @author Brahian
 * clase principal para conexión  a base de datos
 */
public class DBConnection {
    public static Connection connection;
    public static Statement statament;
    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB = "bdkeys";
    private final String USER = "developer";
    private final String PASSWORD = "developer";
    
    
    public void connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" +
                                            PORT + "/" + DB, USER, PASSWORD);
            statament = connection.createStatement();
            System.out.println("Conectado!");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            MessageUtils.showErrorMessage("Error de conexión a la base de datos D: ");
        }
    }
    
    public void disconnect()
    {
        try {
            if(statament != null)
            {
                statament.close();
            }    
            if (connection != null) 
            {
                connection.close();
            }
            System.out.println("¡Desconectado!");
        } catch (Exception e) {
            MessageUtils.showErrorMessage("Error desconectándose de la BD");
        }
    }
}
