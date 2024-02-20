package org.example;

import org.example.clases.Forum;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Forum forum = new Forum();

        while (true) {
            System.out.println("---Menu---");
            System.out.println("1) Publish news.");
            System.out.println("2) Show news feed.");
            System.out.println("3) Aprove news.");
            System.out.println("4) Show all news (both accepted and unaccepted).");
            System.out.println("5) Show all users.");
            System.out.println("6) Exit");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Your choice is:");
            Integer choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    forum.publishNews();
                    break;
                case 2:
                    forum.printNewsForUser();
                    break;
                case 3:
                    forum.approveNews();
                    break;
                case 4:
                    forum.printAllNews();
                    break;
                case 5:
                    forum.printUsers();
                    break;
                case 6:
                    System.out.println("You chose to exit the app.");
                    return;
                default:
                    System.out.println("Incorrect choice.");
                    break;
            }
        }
    }
}
