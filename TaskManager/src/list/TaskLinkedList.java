package list;

import model.Node;
import model.Task;

public class TaskLinkedList {
    private Node head;
    private int size;

    // Add Task (with duplicate check)
    public synchronized void addTask(Task task) {

        if (searchTask(task.getTaskId()) != null) {
            System.out.println("Task ID already exists!");
            return;
        }

        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        size++;
        System.out.println("Task Added Successfully.");
    }

    // Delete Task
    public synchronized boolean deleteTask(int taskId) {
        if (head == null) return false;

        if (head.task.getTaskId() == taskId) {
            head = head.next;
            size--;
            return true;
        }

        Node temp = head;
        while (temp.next != null && temp.next.task.getTaskId() != taskId) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
            size--;
            return true;
        }

        return false;
    }

    // Search Task
    public synchronized Task searchTask(int taskId) {
        Node temp = head;

        while (temp != null) {
            if (temp.task.getTaskId() == taskId) {
                return temp.task;
            }
            temp = temp.next;
        }

        return null;
    }

    // Display Tasks
    public synchronized void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Node temp = head;
        System.out.println("Task List:");

        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    // Reverse Linked List
    public synchronized void reverseTasks() {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        System.out.println("Task list reversed.");
    }

    // Get Count
    public synchronized int getTaskCount() {
        return size;
    }

    //one thread a time
    public synchronized Task getNextPendingTask() {
        Node temp = head;

        while (temp != null) {
            if ("PENDING".equals(temp.task.getStatus())) {
                temp.task.setStatus("IN_PROGRESS");
                return temp.task;
            }
            temp = temp.next;
        }

        return null;
    }
}