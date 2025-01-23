package org.magicmafia.ntm.neko_task_manager.management;

import java.time.LocalDateTime;

public class Task {
    public int priority;
    public String status;
    public LocalDateTime dueDate;
    public String comment;
    public String description;
    public int taskID;


    public Task(int taskID, int priority, String status, LocalDateTime dueDate, String comment, String description) {
        this.taskID = taskID;
        this.priority = priority;
        this.status = status;
        this.dueDate = dueDate;
        this.comment = comment;
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getDueDate() {
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


}
