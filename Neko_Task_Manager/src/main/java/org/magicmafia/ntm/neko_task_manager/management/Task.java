package org.magicmafia.ntm.neko_task_manager.management;

import java.time.LocalDateTime;

public class Task {
    public String name;
    public int priority;
    public String status;
    public LocalDateTime dueDate;
    public String comment;
    public String description;
    private int taskID;
    private static int IDs;


    public Task() {
        IDs ++;
        this.taskID = IDs;
    }

}
