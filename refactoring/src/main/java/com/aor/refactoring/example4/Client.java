package com.aor.refactoring.example4;

public class Client extends Person {

    public Client(String name, String phone) {
        super(name, phone);
    }

    public boolean login(String username, String password) {
        return false;
    }
}
