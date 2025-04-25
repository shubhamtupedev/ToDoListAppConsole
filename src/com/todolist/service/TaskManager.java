package com.todolist.service;

import com.todolist.model.Task;
import com.todolist.util.DateUtils;
import com.todolist.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> taskList = new ArrayList<>();
    private int idCounter = 1;

    public void addTask(String title, String description, String dueDate) {
        boolean isValidationFailed = false;

        if (StringUtils.isNullOrEmpty(title)) {
            System.err.println("please enter valid title, it should not be blank.");
            isValidationFailed = true;
        }

        if (StringUtils.isNullOrEmpty(description)) {
            System.err.println("please enter valid description, it should not be blank.");
            isValidationFailed = true;
        }

        if (StringUtils.isNullOrEmpty(dueDate)) {
            System.err.println("please enter valid due date, it should not be blank.");
            isValidationFailed = true;
        }

        if (title.length() > 50) {
            System.err.println("please enter valid title, it should not be more than 50 characters.");
            isValidationFailed = true;
        }

        if (description.length() > 50) {
            System.err.println("please enter valid title, it should not be more than 50 characters.");
            isValidationFailed = true;
        }

        if (!StringUtils.isNullOrEmpty(dueDate) && !DateUtils.isValidDate(dueDate)) {
            System.err.println("please enter valid date, it should be in this format {YYYY-MM-DD}.");
            isValidationFailed = true;
        }

        if (isValidationFailed) {
            System.out.println("\n");
            return;
        }

        LocalDate localDueDate = LocalDate.parse(dueDate);
        Task task = new Task(idCounter++, title, description, localDueDate);
        taskList.add(task);
        System.out.println("task added successfully.");
    }

    public void readTask() {
        if (taskList.isEmpty()) {
            System.err.println("No record found.");
            return;
        }
        taskList.forEach(System.out::println);
    }

    public void markTaskDone(int taskId) {
        for (Task t : taskList) {
            if (t.getId() == taskId) {
                t.markAsDone();
                System.out.println("task marked as done.");
                return;
            }
        }
        System.out.println("task id not found");
    }

    public void removeTask(int taskId) {
        if (taskList.isEmpty()) {
            System.err.println("No Records found");
            return;
        }

        taskList.removeIf(task -> task.getId() == taskId);
        System.out.println("task removed successfully.");
    }


}
