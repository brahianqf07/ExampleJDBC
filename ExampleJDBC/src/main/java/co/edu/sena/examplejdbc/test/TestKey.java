/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.DBKey;
import co.edu.sena.examplejdbc.model.Key;
import java.util.List;

/**
 *
 * @author Brahian Quintero
 */
public class TestKey {
    public static void main(String[] args) {
        DBKey dBKey = new DBKey();
        //Insertar:
        Key key = new Key(5,"BICENTENARIO","Sala 2", 2, "Llavero");
        dBKey.insert(key);
        //Actualizar
        key.setId(5);
        key.setName("INFORMATICA 3");
        key.setRoom("salón 202");
        key.setCount(1);
        key.setObservation("Llave sola");
        dBKey.update(key);
        //Eliminar
        dBKey.delete(5);
        //consultar
        List<Key> listKey = dBKey.findALL();
        for (Key e : listKey) {
            System.out.println("id: " + e.getId() + "name: " + e.getName() + "room: " + e.getRoom()
            + "count: " + e.getCount() + "observation: " + e.getObservation());
        }
        //Comsultar por id
        System.out.println("**********************************");
        Key key2 = dBKey.findById(1);
        if (key2 != null) 
        {
            System.out.println("id: " + key2.getId() + "name: " + key2.getName() + "room: " + key2.getRoom()
            + "count: " + key2.getCount() + "observation: " + key2.getObservation());  
        }
          
    }
}

