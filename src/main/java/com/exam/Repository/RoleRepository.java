package com.exam.Repository;

import com.exam.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    //It will give all database method (save, update, delete, get)

}
