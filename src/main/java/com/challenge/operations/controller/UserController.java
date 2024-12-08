package com.challenge.operations.controller;

import com.challenge.operations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * UserController is a REST controller that handles HTTP requests related to user accounts,
 * specifically for managing user balances. It provides endpoints for adding balance to a user account
 * and retrieving a user's balance.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/add-balance")
    public ResponseEntity<String> addBalance(@RequestParam Long userId, @RequestParam BigDecimal amount) {
        userService.addBalance(userId, amount);
        return ResponseEntity.ok("Balance added successfully!");
    }

    @GetMapping("/balance")
    public ResponseEntity<BigDecimal> getBalance(@RequestParam Long userId) {
        return ResponseEntity.ok(userService.getBalance(userId));
    }
}
