package org.example;

public class User {

    private String userLogin;
    private String userEmail;

    public User() {
    }

    public User(String login, String email) {
        setUserLogin(login);
        setUserEmail(email);
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserLogin(String login) {
        if (login == null
                || login.isEmpty()
                || login.isBlank()) {
            throw new IllegalArgumentException("Введите корректный логин.");
        }
        this.userLogin = login;
    }

    public void setUserEmail(String email) {

        if (email == null
                || email.isEmpty()
                || email.isBlank()
                || !email.contains("@")
                || !email.contains(".")) {
            throw new IllegalArgumentException("Введите корректную почту.");
        } else {
            this.userEmail = email;
        }
    }


}
