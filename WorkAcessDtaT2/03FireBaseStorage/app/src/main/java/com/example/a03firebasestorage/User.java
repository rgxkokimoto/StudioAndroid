package com.example.a03firebasestorage;

public class User {

    private String firstName, lasteName , userName, email, imageUrl;
    private int age;

    public User() {
    }

    public User(String firstName, String lasteName, String userName, String email, String imageUrl, int age) {
        this.firstName = firstName;
        this.lasteName = lasteName;
        this.userName = userName;
        this.email = email;
        this.imageUrl = imageUrl;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLasteName() {
        return lasteName;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getAge() {
        return age;
    }
}
