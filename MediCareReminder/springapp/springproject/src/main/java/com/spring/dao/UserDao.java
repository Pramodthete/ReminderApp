package com.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.pojos.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{

}
