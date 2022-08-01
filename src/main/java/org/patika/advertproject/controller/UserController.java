package org.patika.advertproject.controller;


import org.patika.advertproject.model.dto.UserDataDTO;
import org.patika.advertproject.model.dto.UserLoginDTO;
import org.patika.advertproject.model.entity.User;
import org.patika.advertproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER')")
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping("/signin")
    public String login(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        return userService.signin(userLoginDTO.getUsername(), userLoginDTO.getPassword());
    }

    @PostMapping("/signup")
    public String signup(@RequestBody @Valid UserDataDTO userDataDTO) {
        User user = new User();
        user.setUsername(userDataDTO.getUsername());
        user.setEmail(userDataDTO.getEmail());
        user.setPassword(userDataDTO.getPassword());
        return userService.signup(user, false);
    }

    @RolesAllowed("ROLE_ADMIN")
    @DeleteMapping(value = "/delete/{username}")
    public String delete(@PathVariable String username) {
        userService.delete(username);
        return username;
    }


}
