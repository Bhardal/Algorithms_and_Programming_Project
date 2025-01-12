package org.magicmafia.ntm.neko_task_manager.management;

import java.util.ArrayList;

public class Management {
    public ArrayList<Employee> listEmployee;
    public ArrayList<Project> listProject;


    public Management() {
        this.listEmployee = new ArrayList<Employee>();
        this.listProject = new ArrayList<Project>();
    }


    public ArrayList<Employee> createEmployee(int employeeID, String name) {
        Employee tempEmployee = new Employee(employeeID, name);
        listEmployee.add(tempEmployee);
        return listEmployee;
    }


    public ArrayList<Employee> editEmployee(int employeeID, String name) {
        return listEmployee;
    }


    public void getListEmployee() {
        for (Employee i : listEmployee) {
            System.out.println(i);
        }
    }
}
