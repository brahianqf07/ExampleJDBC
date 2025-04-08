/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.DBEmployee;
import co.edu.sena.examplejdbc.bd.DBKey;
import co.edu.sena.examplejdbc.bd.DBRecord;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.Record;
import co.edu.sena.examplejdbc.model.Key;
import java.util.List;

/**
 *Fecha:25/03/2025
 * @author Brahian Quintero
 * Objetivo:
 */
public class TestRecord {
    public static void main(String[] args) {
        DBRecord dbr = new DBRecord();
        DBEmployee dbe = new DBEmployee();
        DBKey dbk = new DBKey();
        //Insertar
        Employee employee = dbe.findByid(1117);
        Key key = dbk.findById(4);
        Record record = new Record(0,"2025/03/20", "12:25", "01:00", employee, key, "PENDIENTE");
        //dbr.insert(record);
    
        //actualizar
        Record record1 = new Record(4, "2025-03-29", "07:00:00", "01:15:00", employee, key, "PENDIENTE");
        //dbr.update(record1);
    
        //eliminar
        //dbr.delete(4);
          
        //consultar todos
        List<Record> records = dbr.findAll();
        for(Record e : records){
            System.out.println("id: " + e.getId()
                    + " dateRecord: " + e.getDateRecord()
                    + " startTime: " + e.getStartTime()
                    + " endTime: " + e.getEndTime()
                    + " employeeId: " + e.getEmployee().getDocument()
                    + " keyId: " + e.getKey().getId()
                    + " status: " + e.getStatus());
        }
        //consultar por id
        System.out.println("");
        Record record2 = dbr.findById(1);
        System.out.println("id: " + record2.getId() +
                "dateRecord: " + record2.getDateRecord()+
                "startTime: " + record2.getStartTime()+ 
                "endTime: " + record2.getEndTime()+
                "employee: " + record2.getEmployee().getDocument()+ 
                "key: " + record2.getKey().getId()+
                "status: " + record2.getStatus());
    
}
}
