package ui;

import model.User;

import java.util.Scanner;

/**
 * Menu shown after a successful login. Logging out returns to the main menu.
 */
public class UserMenu {

    private final Scanner sc;
    private final User user;

    public UserMenu(Scanner sc, User user) {
        this.sc = sc;
        this.user = user;
    }

    public void show() {
        System.out.println("\nWelcome, " + user.username() + "!");
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n--- Dashboard ---");
            System.out.println("Role  : " + user.roles());
            System.out.println("Status: " + user.status());
            System.out.println("1. View Profile");
            System.out.println("2. Logout");
            System.out.print("Choose: ");

            switch (sc.nextLine().trim()) {
                case "1" -> {
                    System.out.println("\nID       : " + user.id());
                    System.out.println("Username : " + user.username());
                    System.out.println("Role     : " + user.roles());
                    System.out.println("Status   : " + user.status());
                }
                case "2" -> {
                    System.out.println("Logged out. Returning to main menu...");
                    loggedIn = false;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
