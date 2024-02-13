package com.exam.Repository;

import com.exam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    //It will give all database method (save, update, delete, get)


    public User findByUserName(String userName);

}
