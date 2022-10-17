package com.example.task3.interfaces;

import com.example.task3.data.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginUserRepository extends JpaRepository<LoginUser, String> {

}
