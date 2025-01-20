package org.magicmafia.ntm.neko_task_manager.management;

import java.sql.Date;


public class Project {
    private String projectName;
    private int projectID;
    private Date deadlines;
    private String status;
    private String tasks;

    public Project(int projectID, String projectName, Date deadlines, String status, String tasks) {
        this.projectName = projectName;
        this.projectID = projectID;
        this.deadlines = deadlines;
        this.status = status;
        this.tasks = tasks;
    }

    public Integer getProjectID() {
        return projectID;
    }

    public String getName() {
        return projectName;
    }

    public Date getDeadline() {
        return deadlines;
    }

    public String getStatus() {
        return status;
    }

    public String getTasks() {
        return tasks;
    }
}
