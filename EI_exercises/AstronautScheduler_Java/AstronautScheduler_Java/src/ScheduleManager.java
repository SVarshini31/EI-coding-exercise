import java.util.*;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private Observer observer;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observer = new ConsoleObserver();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    private boolean validateTimeFormat(String time) {
        try {
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            return hour >= 0 && hour < 24 && minute >= 0 && minute < 60;
        } catch (Exception e) {
            return false;
        }
    }

    private Task checkConflict(String start, String end) {
        for (Task task : tasks) {
            if (!(end.compareTo(task.getStartTime()) <= 0 || start.compareTo(task.getEndTime()) >= 0)) {
                return task;
            }
        }
        return null;
    }

    public void addTask(String description, String startTime, String endTime, String priority) {
        if (!validateTimeFormat(startTime) || !validateTimeFormat(endTime)) {
            System.out.println("Error: Invalid time format.");
            return;
        }

        Task conflict = checkConflict(startTime, endTime);
        if (conflict != null) {
            observer.update("Task conflicts with existing task '" + conflict.getDescription() + "'.");
            return;
        }

        Task task = TaskFactory.createTask(description, startTime, endTime, priority);
        tasks.add(task);
        tasks.sort(Comparator.comparing(Task::getStartTime));
        System.out.println("Task added successfully. No conflicts.");
    }

    public void removeTask(String description) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getDescription().equals(description)) {
                iterator.remove();
                System.out.println("Task removed successfully.");
                return;
            }
        }
        System.out.println("Error: Task not found.");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void editTask(String description) {
        Scanner scanner = new Scanner(System.in);
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                System.out.print("Enter new description (leave blank to keep): ");
                String newDesc = scanner.nextLine();
                if (!newDesc.isEmpty()) task.setDescription(newDesc);

                System.out.print("Enter new start time (HH:MM or blank): ");
                String newStart = scanner.nextLine();
                if (!newStart.isEmpty() && validateTimeFormat(newStart)) task.setStartTime(newStart);

                System.out.print("Enter new end time (HH:MM or blank): ");
                String newEnd = scanner.nextLine();
                if (!newEnd.isEmpty() && validateTimeFormat(newEnd)) task.setEndTime(newEnd);

                System.out.print("Enter new priority (High/Medium/Low or blank): ");
                String newPriority = scanner.nextLine();
                if (!newPriority.isEmpty()) task.setPriority(newPriority);

                System.out.println("Task updated successfully.");
                return;
            }
        }
        System.out.println("Error: Task not found.");
    }

    public void markCompleted(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                task.setCompleted(true);
                System.out.println("Task marked as completed.");
                return;
            }
        }
        System.out.println("Error: Task not found.");
    }

    public void viewTasksByPriority(String priority) {
        boolean found = false;
        for (Task task : tasks) {
            if (task.getPriority().equalsIgnoreCase(priority)) {
                System.out.println(task);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks with priority '" + priority + "'.");
        }
    }
}
