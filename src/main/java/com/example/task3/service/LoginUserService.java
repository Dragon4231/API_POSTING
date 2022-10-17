package com.example.task3.service;

import com.example.task3.data.LoginUser;
import com.example.task3.interfaces.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoginUserService {
    @Autowired
    private final LoginUserRepository loginUserRepository;

    public LoginUserService(LoginUserRepository loginUserRepository) {
        this.loginUserRepository = loginUserRepository;
    }

    public void saveLoginUser(LoginUser loginUser){
        loginUserRepository.save(loginUser);
    }

    public void clear(){
        loginUserRepository.deleteAll();
    }

}
