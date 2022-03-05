package com.example.funhouse.mainscreenff.Model;

/**
 * Created by Shafqat on 6/25/2018.
 */

public class User {
    private String email, password, name, messgae;

    public User() {
    }

    public User(String email, String password, String name, String message) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.messgae = message;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

}
