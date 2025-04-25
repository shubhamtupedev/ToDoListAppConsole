package com.todolist.controller;

import com.todolist.service.TaskManager;

import java.util.Scanner;

public class TaskController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        int choice;
        String title;
        String description;
        String dueDate;
        int taskId;

        while (true) {
            System.out.println("\n=== TO-DO LIST ===");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. List Tasks");
            System.out.println("4. Mark Task as Done");
            System.out.println("5. List Pending Tasks");
            System.out.println("6. List Completed Tasks");
            System.out.println("7. Remove Task");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("please enter title");
                    title = scanner.nextLine();
                    System.out.println("please enter description");
                    description = scanner.nextLine();
                    System.out.println("please enter due date format should be example: 1997-05-25");
                    dueDate = scanner.nextLine();
                    taskManager.addTask(title, description, dueDate);
                    break;
                case 2:
                    System.out.println("please enter task id that you want to update");
                    taskId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("please enter title");
                    title = scanner.nextLine();
                    System.out.println("please enter description");
                    description = scanner.nextLine();
                    System.out.println("please enter due date format should be example: 1997-05-25");
                    dueDate = scanner.nextLine();
                    taskManager.updateTask(taskId, title, description, dueDate);
                case 3:
                    taskManager.readTask();
                    break;
                case 4:
                    System.out.println("please enter task id");
                    taskId = scanner.nextInt();
                    taskManager.markTaskDone(taskId);
                    break;
                case 5:
                    taskManager.listPendingTask();
                    break;
                case 6:
                    taskManager.listCompletedTask();
                    break;
                case 7:
                    System.out.println("please enter task id");
                    taskId = scanner.nextInt();
                    taskManager.removeTask(taskId);
                    break;
                case 8:
                    System.out.println("👋 Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("invalid input please try again!");
            }
        }


    }
}
