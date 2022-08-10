package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.user;

import java.util.List;

@Repository
public interface userdatarepo extends JpaRepository<user, Integer> {
    // List<user> findByReg(String reg);
    user findByReg(String reg);

    user findByPass(String pass);

}
