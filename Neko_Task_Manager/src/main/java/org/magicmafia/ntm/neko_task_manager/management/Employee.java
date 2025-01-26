package org.magicmafia.ntm.neko_task_manager.management;

import java.util.HashSet;
import java.util.Set;

public class Employee {
    private Integer employeeID;
    private String name;
    private Set<String> projects;

    public Employee(Integer employeeID, String name) {
        this.employeeID = employeeID;
        this.name = name;
        this.projects = new HashSet<>();
    }
    

    @Override
    public String toString() {
        return "Employee ID: " + employeeID +
                ", Name: " + name +
                ", Project History: " + projects;
    }


    public void addProject(String project) {
        this.projects.add(project);
    }


    public int getEmployeeID() {
        return employeeID;
    }


    public String getName() {
        return name;
    }


    public Set<String> getProjects() {
        return projects;
    }
}
