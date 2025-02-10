package com.example.a02prubsrealtimedtabase;

public class User {

   private  String firstName;
   private String lastName;
   private String userName;
   private int age;

   public User(String firstName, String lastName, String userName, int age) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.userName = userName;
      this.age = age;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }
}
