package org.magicmafia.ntm.neko_task_manager.management;

import java.sql.Date;


public class Project {
    private String ProjectName;
    private int ProjectID;
    private Date Deadline;
    private String Tasks;
    private String Employees;

    public Project(int ProjectID, String ProjectName, Date Deadline, String Employees , String Tasks) {
        this.ProjectName = ProjectName;
        this.ProjectID = ProjectID;
        this.Deadline = Deadline;
        this.Tasks = Tasks;
        this.Employees = Employees;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public int getProjectID() {
        return ProjectID;
    }

    public Date getDeadline() {
        return Deadline;
    }

    public String getTasks() {
        return Tasks;
    }

    public String getEmployees() {
        return Employees;
    }
}
