package org.example.clases;

public class User {
    private Integer userId;
    private String username;
    private final Integer adminId=1;

    public User() {
    }

    public User(Integer userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAdminId() {
        return adminId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", adminId=" + adminId +
                '}'+"\n";
    }
}