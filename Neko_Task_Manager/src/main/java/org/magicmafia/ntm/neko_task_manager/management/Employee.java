package org.magicmafia.ntm.neko_task_manager.management;

import java.util.ArrayList;

public class Employee {
    private String name;
    private int employeeID;
    private ArrayList<Project> projectHistory;

    public Employee(int employeeID, String name) {
        this.employeeID = employeeID;
        this.name = name;
    }
    

    @Override
    public String toString() {
        return "Employee ID: " + employeeID +
                ", Name: " + name +
                ", Project History: " + projectHistory;
    }


    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setProjectHistory(ArrayList<Project> projectHistory) {
        this.projectHistory = projectHistory;
    }


    public int getEmployeeID() {
        return employeeID;
    }


    public String getName() {
        return name;
    }


    public ArrayList<Project> getProjectHistory() {
        return projectHistory;
    }
}
