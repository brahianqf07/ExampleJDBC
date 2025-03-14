/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.model;

/**
 *
 * @author Aprendiz
 */
public class Key {
    private int id;
    private String name;
    private String room;
    private int count;
    private String Observation;

    public Key() {
    }

    public Key(int id, String name, String room, int count, String Observation) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.count = count;
        this.Observation = Observation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getObservation() {
        return Observation;
    }

    public void setObservation(String Observation) {
        this.Observation = Observation;
    }
    
    
    
    
  
}
