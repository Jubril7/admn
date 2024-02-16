package com.nxgdemo.repo;

import com.nxgdemo.entity.User;
import com.nxgdemo.enums.UserType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Page<User> findByUserType(UserType userType, Pageable pageable);
}
