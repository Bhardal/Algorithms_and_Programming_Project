package org.magicmafia.ntm.neko_task_manager.management;

import java.time.LocalDateTime;
import java.util.Date;

public class Project {
    private String projectName;
    private int projectID;
    private Date deadlines;

    public Project(String projectName, int projectID, Date deadlines) {
        this.projectName = projectName;
        this.projectID = projectID;
        this.deadlines = deadlines;
    }
}
