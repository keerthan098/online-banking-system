package com.bank.bankapp.controller;

import com.bank.bankapp.entity.User;
import com.bank.bankapp.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // REGISTER USER
    @GetMapping("/register")
    public User register(@RequestParam String name,
                         @RequestParam String password,
                         @RequestParam double balance) {
        return service.register(name, password, balance);
    }

    // LOGIN
    @GetMapping("/login")
    public User login(@RequestParam String name,
                      @RequestParam String password) {
        return service.login(name, password);
    }


    // GET USER
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return service.getUser(id);
    }

    // DEPOSIT
    @GetMapping("/{id}/deposit")
    public User deposit(@PathVariable int id,
                        @RequestParam double amount) {
        return service.deposit(id, amount);
    }

    // WITHDRAW
    @GetMapping("/{id}/withdraw")
    public User withdraw(@PathVariable int id,
                         @RequestParam double amount) {
        return service.withdraw(id, amount);
    }
}
