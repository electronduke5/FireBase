package com.example.firebase2;

public class User {
    public String email;
    public String password;
    public String confirmPassword;
    public String phoneNumber;

    public User(String email, String password, String confirmPassword, String phoneNumber){
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.phoneNumber = phoneNumber;
    }
}
