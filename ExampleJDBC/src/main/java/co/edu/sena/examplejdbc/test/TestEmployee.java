/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.DBEmployee;
import co.edu.sena.examplejdbc.bd.DBEmployeeType;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.EmployeeType;
import java.util.List;

/**
 *Fecha: 20/03/2025
 * @author Brahian Quintero
 * Objetivo: probar consultas/transacciones en la tabla employee
**/
public class TestEmployee {
    public static void main(String[] args) {
        DBEmployee dbe = new DBEmployee();
        DBEmployeeType dbet = new DBEmployeeType();
        //Insertar
        EmployeeType employeeType = dbet.findById(1);
        Employee employee = new Employee(111625896, "ELSA BROSÓN", "Av 5a", "310", employeeType);
        dbe.insert(employee);
        //modificar
        employee.setFullname("ELTON TITTO");
        employeeType = dbet.findById(2); //FK
        dbe.update(employee);
        //eliminar
        dbe.delete(111625896);
        //consultar todos
        List<Employee> employees = dbe.findAll();
        for (Employee e : employees) {
            System.out.println("document: " + e.getDocument() + "fullname: " + e.getFullname() +
                        " addres: " + e.getAddress() + "phone: " + e.getPhone() +
                       "type: " + e.getEmployeeType().getDescript());
        }
        //consultar por id
        System.out.println("********************************");
        Employee employee2 = dbe.findByid(1116);
        System.out.println("document: " + employee2.getDocument() + "fullname: " + employee2.getFullname() +
                            "addrres: " + employee2.getAddress() + "phone: " + employee2.getPhone() +
                            "type: " + employee2.getEmployeeType());
    }
}
