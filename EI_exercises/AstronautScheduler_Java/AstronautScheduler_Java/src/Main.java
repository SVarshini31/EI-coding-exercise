import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScheduleManager manager = ScheduleManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Astronaut Daily Schedule Organizer ---");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Edit Task");
            System.out.println("5. Mark Task as Completed");
            System.out.println("6. View Tasks by Priority");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter task description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter start time (HH:MM): ");
                    String start = scanner.nextLine();
                    System.out.print("Enter end time (HH:MM): ");
                    String end = scanner.nextLine();
                    System.out.print("Enter priority (High/Medium/Low): ");
                    String priority = scanner.nextLine();
                    manager.addTask(desc, start, end, priority);
                    break;
                case "2":
                    System.out.print("Enter task description to remove: ");
                    String rdesc = scanner.nextLine();
                    manager.removeTask(rdesc);
                    break;
                case "3":
                    manager.viewTasks();
                    break;
                case "4":
                    System.out.print("Enter task description to edit: ");
                    String edesc = scanner.nextLine();
                    manager.editTask(edesc);
                    break;
                case "5":
                    System.out.print("Enter task description to mark completed: ");
                    String cdesc = scanner.nextLine();
                    manager.markCompleted(cdesc);
                    break;
                case "6":
                    System.out.print("Enter priority (High/Medium/Low): ");
                    String p = scanner.nextLine();
                    manager.viewTasksByPriority(p);
                    break;
                case "7":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
