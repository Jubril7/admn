package com.nxgdemo.serv;

import com.nxgdemo.entity.User;
import com.nxgdemo.enums.UserType;
import com.nxgdemo.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServ {

    private final UserRepo userRepo;

    public Page<User> getUsersByType(UserType userType, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepo.findByUserType(userType, pageable);
    }

    public Page<User> getTalentUsers(int page, int size) {
        return getUsersByType(UserType.TALENT, page, size);
    }

    public Page<User> getAgentUsers(int page, int size) {
        return getUsersByType(UserType.AGENT, page, size);
    }

    public Page<User> getEmployerUsers(int page, int size) {
        return getUsersByType(UserType.EMPLOYER, page, size);
    }

}
