package org.magicmafia.ntm.neko_task_manager.management;

import java.util.ArrayList;

public class Management {
    public ArrayList<Employee> listEmployees;
    public ArrayList<Project> listProject;


    public Management() {
        this.listEmployees = new ArrayList<>();
        this.listProject = new ArrayList<>();
    }
    

    public ArrayList<Employee> createEmployee(int employeeID, String name) {
        Employee tempEmployee = new Employee(employeeID, name);
        listEmployees.add(tempEmployee);
        return listEmployees;
    }


    public ArrayList<Employee> editEmployee(int oldEmployeeID, String oldName, int newEmployeeID, String newName) {
        Employee employee = new Employee(oldEmployeeID, oldName);
        Employee tempEmployee = new Employee(newEmployeeID, newName);
        int index =0;
        for (Employee i : listEmployees) {
            if (listEmployees.contains(employee)) {
                listEmployees.set(index, tempEmployee);
            }
            index +=1;
        }
        return listEmployees;
    }

    public ArrayList<Employee> deleteEmployee(int employeeID, String name) {
        Employee tempEmployee = new Employee(employeeID, name);
        for (Employee i : listEmployees) {
            if (listEmployees.contains(tempEmployee)) {
                listEmployees.remove(i);
            }
        }
        return listEmployees;
    }


    public void getListEmployee() {
        for (Employee i : listEmployees) {
            System.out.println(i);
        }
    }
}
