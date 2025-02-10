package com.example.a02listasandroid;

public class User {

    private int profileImage;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private int age;

    public User(int profileImage, String username, String firstName, String lastName, String email, int age) {
        this.profileImage = profileImage;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
