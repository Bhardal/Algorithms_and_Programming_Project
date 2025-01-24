package org.magicmafia.ntm.neko_task_manager.management;

import java.sql.Date;

public class Task {
    public int priority;
    public String status;
    public Date dueDate;
    public String comment;
    public String description;
    public int taskID;
    public int projectID;
    public int employeeID;


    public Task(int taskID, int priority, String status, Date dueDate, String comment, String description, int projectID, int employeeID) {
        this.taskID = taskID;
        this.priority = priority;
        this.status = status;
        this.dueDate = dueDate;
        this.comment = comment;
        this.description = description;
        this.projectID = projectID;
        this.employeeID = employeeID;
    }

    public int getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getComment() {
        return comment;
    }

    public String getDescription() {
        return description;
    }

    public int getTaskID() {
        return taskID;
    }

    public int getProjectID() {
        return projectID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
