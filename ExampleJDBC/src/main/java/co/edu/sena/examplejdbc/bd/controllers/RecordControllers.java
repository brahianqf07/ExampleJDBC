/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.controllers;
import co.edu.sena.examplejdbc.bd.DBRecord;
import co.edu.sena.examplejdbc.model.Record;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class RecordControllers implements IRecordControllers{
    
    private DBRecord dbr = new DBRecord();
    
                 
    @Override
    public void insert(Record record) throws Exception {
        if(record == null)
    {
        throw new Exception("El tipo de llave es nulo");
    }
        if("".equals(record.getDateRecord()))
        {
            throw new Exception("La feceha es obliigatoria");
        }
        if("".equals(record.getStartTime()))
        {
            throw new Exception("La hora de inicio es obligatoria");
        }
        if("".equals(record.getEmployee()))
        {
            throw new Exception("El id del empleado es obligatorio");
        }
        if("".equals(record.getKey()))
        {
            throw new Exception("El id de la llave es obligatorio");
        }
        if("".equals(record.getStatus()))
        {
            throw new Exception("El estado es obligatorio");
        }
         //insertar
        dbr.insert(record);        
        
    }

    @Override
    public void update(Record record) throws Exception {
        if(record == null)
    {
        throw new Exception("El registro es nulo");
    }
        if(record.getId()== 0)
        {
            throw new Exception("El id es obligatorio");
        }
        if("".equals(record.getDateRecord()))
        {
            throw new Exception("La feceha es obliigatoria");
        }
        if("".equals(record.getStartTime()))
        {
            throw new Exception("La hora de inicio es obligatoria");
        }
        if("".equals(record.getEmployee()))
        {
            throw new Exception("El id del empleado es obligatorio");
        }
        if("".equals(record.getKey()))
        {
            throw new Exception("El id de la llave es obligatorio");
        }
        if("".equals(record.getStatus()))
        {
            throw new Exception("El estado es obligatorio");
        }
        //actualizar
        dbr.update(record);
    }

    @Override
    public void delete(int id) throws Exception {
         if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        //consultar si el key existe en la bd
        Record recordExist = dbr.findById(id);
        if( recordExist == null)
        {
            throw new Exception("El tipo de regidtro no existe");
        }
        //Eliminar
        dbr.delete(id);
    }

    @Override
    public List<Record> findAll() throws Exception {
        return dbr.findAll();
    }

    @Override
    public Record findById(int id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        return dbr.findById(id);
    }
    
}