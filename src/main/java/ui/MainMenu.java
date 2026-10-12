package ui;

import dao.UserDao;
import model.User;

import java.util.Optional;
import java.util.Scanner;

/**
 * Main menu: Register, Login, Exit.
 */
public class MainMenu {

    private final Scanner sc = new Scanner(System.in);
    private final UserDao userDao = new UserDao();

    public void show() {
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("=====================================");
            System.out.println("  Online Event Catering and Booking System");
            System.out.println("=====================================");
            System.out.println("1. Register Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            switch (sc.nextLine().trim()) {
                case "1" -> register();
                case "2" -> login();
                case "3" -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    private void register() {
        System.out.println("\n--- Register Account ---");
        System.out.print("Username: ");
        String username = sc.nextLine().trim();
        if (username.isEmpty()) {
            System.out.println("Username cannot be empty.");
            return;
        }
        if (userDao.usernameExists(username)) {
            System.out.println("Username already taken.");
            return;
        }

        System.out.print("Password: ");
        String password = sc.nextLine();
        if (password.isEmpty()) {
            System.out.println("Password cannot be empty.");
            return;
        }

        String role = null;
        while (role == null) {
            System.out.println("Role: 1. TEACHER   2. STUDENT");
            System.out.print("Choose: ");
            switch (sc.nextLine().trim()) {
                case "1" -> role = "TEACHER";
                case "2" -> role = "STUDENT";
                default -> System.out.println("Invalid role choice.");
            }
        }

        if (userDao.register(username, password, role)) {
            System.out.println("Registered successfully! Status: PENDING");
        } else {
            System.out.println("Registration failed.");
        }
    }

    private void login() {
        System.out.println("\n--- Login ---");
        System.out.print("Username: ");
        String username = sc.nextLine().trim();
        System.out.print("Password: ");
        String password = sc.nextLine();

        Optional<User> user = userDao.login(username, password);
        if (user.isPresent()) {
            new UserMenu(sc, user.get()).show();
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}
