/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.DBConnection;

/**
 *Fecha: 13/03/2025
 * @author Brahian Quintero
 * objetivo: Probaar la conexión a la base de datos
 */
public class TestConnection {
    public static void main(String[] arg) {
        DBConnection connection = new DBConnection();
        connection.connect();
        connection.disconnect();
    }
}