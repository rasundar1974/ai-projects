import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Simple CLI To-Do List App");
        while (true) {
            System.out.print("Enter command (add/list/delete/exit): ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting.");
                break;
            } else if (input.startsWith("add ")) {
                String task = input.substring(4).trim();
                if (!task.isEmpty()) {
                    tasks.add(task);
                    System.out.println("Added: " + task);
                } else {
                    System.out.println("Task cannot be empty.");
                }
            } else if (input.equals("list")) {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks.");
                } else {
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                }
            } else if (input.startsWith("delete ")) {
                try {
                    int idx = Integer.parseInt(input.substring(7).trim()) - 1;
                    if (idx >= 0 && idx < tasks.size()) {
                        String removed = tasks.remove(idx);
                        System.out.println("Deleted: " + removed);
                    } else {
                        System.out.println("Invalid task number.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please provide a valid task number.");
                }
            } else {
                System.out.println("Unknown command.");
            }
        }
        scanner.close();
    }
}
