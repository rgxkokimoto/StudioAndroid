package com.example.a02listasrecicleview;

public class User {

    private String profileImage;
    private Integer age;
    private String username , firstName , lastName , email;

    public User(String profileImage, Integer age, String username, String firstName, String lastName, String email) {
        this.profileImage = profileImage;
        this.age = age;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Contructror vacio para fireBase

    public User() {

    }

    public String getProfileImage() {
        return profileImage;
    }

    public int getAge() {
        return age;
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
}
