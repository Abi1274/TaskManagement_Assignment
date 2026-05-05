package main;

import list.TaskLinkedList;
import model.Task;
import thread.TaskProcessor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TaskLinkedList taskList = new TaskLinkedList();
        Scanner sc = new Scanner(System.in);

        int choice = 0;

        do {

            System.out.println("\n1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Search Task");
            System.out.println("4. Display All Tasks");
            System.out.println("5. Reverse Task List");
            System.out.println("6. Start Task Processing");
            System.out.println("7. Exit");

            try {
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input!");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    try {
                        System.out.print("Enter Task ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Task Name: ");
                        String name = sc.nextLine();

                        String priority;

                        while (true) {
                            System.out.print("Enter Priority (HIGH/MEDIUM/LOW): ");
                            priority = sc.nextLine().toUpperCase();

                            if (priority.equals("HIGH") || priority.equals("MEDIUM") || priority.equals("LOW")) {
                                break;
                            } else {
                                System.out.println("Invalid priority!");
                            }
                        }

                        taskList.addTask(new Task(id, name, priority));

                    } catch (Exception e) {
                        System.out.println("Invalid input!");
                        sc.nextLine();
                    }
                    break;

                case 2:
                    System.out.print("Enter Task ID: ");
                    int delId = sc.nextInt();
                    System.out.println(taskList.deleteTask(delId) ? "Task deleted." : "Task not found.");
                    break;

                case 3:
                    System.out.print("Enter Task ID: ");
                    int searchId = sc.nextInt();
                    Task t = taskList.searchTask(searchId);
                    System.out.println(t != null ? t : "Task not found.");
                    break;

                case 4:
                    taskList.displayTasks();
                    break;

                case 5:
                    taskList.reverseTasks();
                    break;

                case 6:
                    System.out.println("\nStarting Task Processing...");

                    Thread t1 = new Thread(new TaskProcessor(taskList, "Worker-1"));
                    Thread t2 = new Thread(new TaskProcessor(taskList, "Worker-2"));

                    t1.start();
                    t2.start();

                    try {
                        t1.join();
                        t2.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("\nAll tasks completed.");
                    break;
            }

        } while (choice != 7);

        sc.close();
    }
}