package org.magicmafia.ntm.neko_task_manager.management;

import java.time.LocalDateTime;

public class Project {
    private Employee listStaff;
    protected Task listTask;
    private String projectName;
    private String projectID;
    private LocalDateTime deadlines;

    public Project(String projectName) {
        this.projectName = projectName;
    }
}
