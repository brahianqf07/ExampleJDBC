/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.DBKey;
import co.edu.sena.examplejdbc.model.Key;

/**
 *
 * @author Brahian Quintero
 */
public class TestKey {
    public static void main(String[] args) {
        DBKey dBKey = new DBKey();
        //Insertar:
        Key key = new Key(5,"mi casa","Sala2", 2, "Llavero");
        dBKey.insert(key);
    }
}
