package list;

import model.Node;
import model.Task;

public class TaskLinkedList {

    private Node head;
    private int size;

// ADD TASK
    public synchronized void addTask(Task task) {

// Prevent duplicate ID
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

// DELETE TASK
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

 // SEARCH TASK
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

    // DISPLAY TASKS
    public synchronized void displayTasks() {

        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Node temp = head;

        System.out.println("\nTask List:");
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

// REVERSE LIST
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

// COUNT
    public synchronized int getTaskCount() {
        return size;
    }

//CRITICAL METHOD (Synchronization)
    public synchronized Task getNextPendingTask() {

        Node temp = head;

        while (temp != null) {

            if ("PENDING".equals(temp.task.getStatus())) {

            // Mark immediately to avoid race condition
                temp.task.setStatus("IN_PROGRESS");

                return temp.task;
            }

            temp = temp.next;
        }

        return null;
    }
}