package com.example.chatapp.Models;

public class User {
    // user characteristics
    String profilePicture;
    String userName;
    String email;
    String password;
    String userId;
    String lastMessage;

    // constructors
    public User(String profilePicture, String userName, String email, String password, String userId, String lastMessage) {
        this.profilePicture = profilePicture;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userId = userId;
        this.lastMessage = lastMessage;
    }

    // empty constructor for Firebase
    public User(){}

    // for sign up
    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    // getters and setters
    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}
