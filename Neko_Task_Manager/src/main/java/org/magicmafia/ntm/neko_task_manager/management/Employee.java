package org.magicmafia.ntm.neko_task_manager.management;
public class Employee {
    private Integer employeeID;
    private String name;
    private String projects;

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


    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setProjectHistory(String projects) {
        this.projects = projects;
    }


    public int getEmployeeID() {
        return employeeID;
    }


    public String getName() {
        return name;
    }


    public String getProjects() {
        return projects;
    }
}
