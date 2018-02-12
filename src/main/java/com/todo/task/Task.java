package com.todo.task;

public class Task {
    private long id;
    private String taskName;
    private String taskCompletedByUser;

    public Task(long id, String taskName, String taskCompletedByUser) {
        this.id = id;
        this.taskName = taskName;
        this.taskCompletedByUser = taskCompletedByUser;
    }

    public long getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskCompletedByUser() {
        return taskCompletedByUser;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskCompletedByUser='" + taskCompletedByUser + '\'' +
                '}';
    }
}
