package org.example.clases;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Forum {
    private List<News> forumNews;
    private List<User> forumUsers;

    public Forum() {
        forumNews = getNewsFromFile();
        System.out.println(forumNews);
        forumUsers = getUsersFromFile();
        System.out.println(forumUsers);
    }

    private List<News> getNewsFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(
                    new File("src/main/java/org/example/resources/news"),
                    new TypeReference<List<News>>() {});
        } catch (IOException e) {
            System.err.println("An error occurred while trying to get news from file.");
        }
        return Collections.emptyList();
    }

    private List<User> getUsersFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(
                    new File("src/main/java/org/example/resources/users"),
                    new TypeReference<List<User>>() {});
        } catch (IOException e) {
            System.err.println("An error occurred while trying to get users from file.");
        }
        return Collections.emptyList();
    }

    public void printAllNews() {
        System.out.println("News:");
        for (News news : forumNews) {
            System.out.println(news);
        }
    }

    public void printNewsForUser() {
        System.out.println("You want to view news.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user ID:");
        Integer userId = scanner.nextInt();
        User user = getUserById(userId);
        if (user != null) {
            System.out.println("Approved News or your created news:");
            for (News news : forumNews) {
                if (news.getIsApproved() || news.getPublisherId().equals(user.getUserId())||user.getUserId().equals(user.getAdminId())) {
                    System.out.println(news);
                }
            }
        } else System.out.println("User is not registered to forum.");
    }

    public void printUsers() {
        System.out.println("Users:");
        for (User user : forumUsers) {
            System.out.println(user);
        }
    }

    public void publishNews() {
        System.out.println("You want to publish news.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter user ID:");
        Integer userId = scanner.nextInt();
        User user = getUserById(userId);
        if (user == null) {
            System.out.println("User with id " + userId + " not found.");
            return;
        }
        scanner.nextLine();

        System.out.println("Enter news content:");
        String content = scanner.nextLine();

        if (user != null) {
            News news = new News(forumNews.size() + 1, content, user.getUserId(), false);
            forumNews.add(news);
            if (user.getUserId().equals(user.getAdminId())) {
                news.setIsApproved(true);
                System.out.println(user.getUsername() + " with admin privileges posted: " + content);
            } else {
                System.out.println(user.getUsername() + " sent the following post for approval: " + content);
            }
        } else {
            System.out.println("User with id " + userId + " not found.");
        }
    }

    public void approveNews() {
        System.out.println("You want to approve news.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter user ID:");
        Integer userId = scanner.nextInt();
        User user = getUserById(userId);
        if (user == null || !user.getUserId().equals(user.getAdminId())) {
            System.out.println("User with id " + userId + " is not an admin.");
            return;
        } else System.out.println("Welcome " + user.getUsername());

        System.out.println("Enter news ID to approve:");
        Integer newsId = scanner.nextInt();
        News news = getNewsById(newsId);
        if (news != null) {
            news.setIsApproved(true);
            System.out.println("News with id " + newsId + " has been approved by admin " + user.getUsername());
        } else {
            System.out.println("News with id " + newsId + " not found.");
        }
    }

    private News getNewsById(Integer newsId) {
        for (News news : forumNews) {
            if (news.getNewsId().equals(newsId)) {
                return news;
            }
        }
        return null;
    }
    private User getUserById(Integer userId) {
        for (User user : forumUsers) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

}
