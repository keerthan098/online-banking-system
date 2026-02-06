package com.bank.bankapp.service;

import com.bank.bankapp.entity.User;
import com.bank.bankapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    // register new user
    public User register(String name, String password, double balance) {
        User u = new User(name, password, balance);
        return repo.save(u);
    }

    // login
    public User login(String name, String password) {
        User u = repo.findByName(name).orElse(null);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }

    // get user by id
    public User getUser(int id) {
        return repo.findById(id).orElse(null);
    }

    // deposit
    public User deposit(int id, double amount) {
        User u = getUser(id);
        if (u != null) {
            u.setBalance(u.getBalance() + amount);
            return repo.save(u);
        }
        return null;
    }

    // withdraw
    public User withdraw(int id, double amount) {
        User u = getUser(id);
        if (u != null && u.getBalance() >= amount) {
            u.setBalance(u.getBalance() - amount);
            return repo.save(u);
        }
        return null;
    }
}
