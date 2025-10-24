package ru.mirea.fedoseev.practice4;

public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean authenticate(String inputLogin, String inputPassword) {
        return this.login.equals(inputLogin) && this.password.equals(inputPassword);
    }
}
