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
            System.out.println("please enter valid title, it should not be blank.");
            isValidationFailed = true;
        }

        if (StringUtils.isNullOrEmpty(description)) {

            System.out.println("please enter valid description, it should not be blank.");
            isValidationFailed = true;
        }

        if (StringUtils.isNullOrEmpty(dueDate)) {

            System.out.println("please enter valid due date, it should not be blank.");
            isValidationFailed = true;
        }

        if (title.length() > 50) {

            System.out.println("please enter valid title, it should not be more than 50 characters.");
            isValidationFailed = true;
        }

        if (description.length() > 200) {

            System.out.println("please enter valid description, it should not be more than 50 characters.");
            isValidationFailed = true;
        }

        if (!StringUtils.isNullOrEmpty(dueDate) && !DateUtils.isValidDate(dueDate)) {

            System.out.println("please enter valid date, it should be in this format {YYYY-MM-DD}.");
            isValidationFailed = true;
        }

        if (isValidationFailed) {
            return;
        }

        LocalDate localDueDate = LocalDate.parse(dueDate);
        Task task = new Task(idCounter++, title, description, localDueDate);
        taskList.add(task);
        System.out.println("task added successfully.");
    }

    public void readTask() {
        if (taskList.isEmpty()) {
            System.out.println("No record found.");
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
            System.out.println("No Records found");
            return;
        }

        taskList.removeIf(task -> task.getId() == taskId);
        System.out.println("task removed successfully.");
    }

    public void updateTask(int taskId, String title, String description, String dueDate) {
        boolean isValidationFailed = false;
        if (taskList.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        if (StringUtils.isNullOrEmpty(title)) {
            System.out.println("please enter valid title, it should not be blank.");
            isValidationFailed = true;
        }

        if (StringUtils.isNullOrEmpty(description)) {
            System.out.println("please enter valid description, it should not be blank.");
            isValidationFailed = true;
        }

        if (StringUtils.isNullOrEmpty(dueDate)) {
            System.out.println("please enter valid due date, it should not be blank.");
            isValidationFailed = true;
        }

        if (title.length() > 50) {
            System.out.println("please enter valid title, it should not be more than 50 characters.");
            isValidationFailed = true;
        }

        if (description.length() > 200) {
            System.out.println("please enter valid description, it should not be more than 50 characters.");
            isValidationFailed = true;
        }

        if (!StringUtils.isNullOrEmpty(dueDate) && !DateUtils.isValidDate(dueDate)) {
            System.out.println("please enter valid date, it should be in this format {YYYY-MM-DD}.");
            isValidationFailed = true;
        }

        if (isValidationFailed) {
            System.out.println("\n");
            return;
        }

        taskList.removeIf(task -> task.getId() == taskId);
        LocalDate localDueDate = LocalDate.parse(dueDate);
        taskList.add(new Task(taskId, title, description, localDueDate));
        System.out.println("task updated successfully.");
    }

    public void listPendingTask() {
        if (taskList.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        List<Task> pendingTaskList = taskList.stream().filter(task -> !task.isCompleted()).toList();
        if (pendingTaskList.isEmpty()) {
            System.out.println("no record found");
            return;
        }

        pendingTaskList.forEach(System.out::println);
    }

    public void listCompletedTask() {
        if (taskList.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        List<Task> completedTaskList = taskList.stream().filter(Task::isCompleted).toList();
        if (completedTaskList.isEmpty()) {
            System.out.println("no record found.");
            return;
        }
        completedTaskList.forEach(System.out::println);
    }


}
