package thread;

import list.TaskLinkedList;
import model.Task;

public class TaskProcessor implements Runnable {

    private TaskLinkedList taskList;
    private String workerName;

    public TaskProcessor(TaskLinkedList taskList, String workerName) {
        this.taskList = taskList;
        this.workerName = workerName;
    }

    @Override
    public void run() {

        while (true) {

            Task task = taskList.getNextPendingTask();

            if (task == null) {
                break;
            }

            System.out.println(workerName + " processing Task ID: " + task.getTaskId());

            try {
                Thread.sleep(2000); // simulate processing
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            task.setStatus("COMPLETED");

            System.out.println(workerName + " completed Task ID: " + task.getTaskId());
        }
    }
}