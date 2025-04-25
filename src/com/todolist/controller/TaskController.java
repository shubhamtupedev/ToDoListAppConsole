package com.todolist.controller;

import com.todolist.service.TaskManager;

import java.util.Scanner;

public class TaskController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        int choice;

        while (true) {
            System.out.println("\n=== TO-DO LIST ===");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("please enter title");
                    String title = scanner.nextLine();
                    System.out.println("please enter description");
                    String description = scanner.nextLine();
                    System.out.println("please enter due date format should be example: 1997-05-25");
                    String dueDate = scanner.nextLine();
                    taskManager.addTask(title, description, dueDate);
                    break;
                case 2:
                    taskManager.readTask();
                    break;
                case 3:
                    System.out.println("please enter task id");
                    int taskId = scanner.nextInt();
                    taskManager.markTaskDone(taskId);
                    break;
                case 4:
                    System.out.println("please enter task id");
                    int taskid = scanner.nextInt();
                    taskManager.removeTask(taskid);
                    break;
                case 5:
                    System.out.println("👋 Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("invalid input please try again!");
            }
        }


    }
}
