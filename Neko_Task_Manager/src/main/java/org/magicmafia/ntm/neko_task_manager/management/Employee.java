package org.magicmafia.ntm.neko_task_manager.management;

public class Employee {
    private final Integer employeeID;
    private final String name;
    private final String projects;

    public Employee(Integer employeeID, String name, String projects) {
        this.employeeID = employeeID;
        this.name = name;
        this.projects = projects;
    }
    

    @Override
    public String toString() {
        return "Employee ID: " + employeeID +
                ", Name: " + name +
                ", Project History: " + projects;
    }

    public int getEmployeeID() {
        return employeeID;
    }


    public String getName() {
        return name;
    }


    public String getProjectHistory() {
        return projects;
    }
}
