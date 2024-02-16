package com.nxgdemo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nxgdemo.serv.UserServ;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServ userServ;

    @GetMapping("/{userType}")
    public ResponseEntity<Object> getUsersByType(
            @PathVariable String userType,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        userType = userType.toLowerCase();

        Object users;
        switch (userType) {
            case "talent" -> users = userServ.getTalentUsers(page, size).getContent();
            case "employer" -> users = userServ.getEmployerUsers(page, size).getContent();
            case "agent" -> users = userServ.getAgentUsers(page, size).getContent();
            default -> {
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.ok(users);
    }
}
