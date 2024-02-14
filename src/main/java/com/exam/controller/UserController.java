package com.exam.controller;


import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //Creating User API
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(445L);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        return this.userService.createUser(user, roles);

    }



    //Getting UserName Details
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username")String username){
        return this.userService.getUser(username);
    }


    // 3 - Step
    // Delete User by Id
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id")Long id){
        this.userService.deleteUser(id);
    }

}
