package model;

public class Task {
    private int taskId;
    private String taskName;
    private String priority; // HIGH, MEDIUM, LOW
    private String status;   // PENDING, IN_PROGRESS, COMPLETED

    public Task(int taskId, String taskName, String priority) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.status = "PENDING";
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return taskId + " - " + taskName + " - " + priority + " - " + status;
    }
}