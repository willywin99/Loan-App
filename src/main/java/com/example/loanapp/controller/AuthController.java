package com.example.loanapp.controller;

import com.example.loanapp.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> req) {

        String user = req.get("username");
        String pass = req.get("password");

        // MOCK USER - demo only
        if ("sales".equals(user) && "password".equals(pass)) {
            String token = jwtUtil.generateToken(user, "SALES");
            return ResponseEntity.ok(Map.of("token", token));
        }

        if ("approver".equals(user) && "password".equals(pass)) {
            String token = jwtUtil.generateToken(user, "APPROVER");
            return ResponseEntity.ok(Map.of("token", token));
        }

        return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
    }
}
