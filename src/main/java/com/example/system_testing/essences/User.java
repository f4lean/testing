package com.example.system_testing.essences;

/**
 * Класс для создания объекта - Пользователь.
 */

public class User {
    private String userLogin;
    private String userPassword;
    private String userRole;

    public User(String userName, String userPassword, String userRole) {
        this.userLogin = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

    public User() {
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
