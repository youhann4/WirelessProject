package com.example.aiproject;

import android.widget.RadioButton;

public class HelperClass {

    String name, email, password,position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public HelperClass(String name, String email, String password, String position) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.position = position;

    }

}
