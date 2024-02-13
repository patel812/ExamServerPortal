package com.exam.service.implementation;

import com.exam.Repository.RoleRepository;
import com.exam.Repository.UserRepository;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //Creating User
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

       User local = this.userRepository.findByUserName(user.getUserName());

       if (local != null){
           System.out.println("User is already there!!");
           throw new Exception("User already present !!");

       }else {
           //User create
           for (UserRole ur:userRoles)
           {
              roleRepository.save(ur.getRole());
           }

           user.getUserRoles().addAll(userRoles);
           local = this.userRepository.save(user);

       }

        return local;
    }





}
