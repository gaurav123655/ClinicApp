package com.cg.bookmydoctor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.bookmydoctor.dto.User;

import java.util.Optional;


@Repository
public interface IUserDao extends JpaRepository<User, Integer>{

  //  Optional<User> findById(String userId);

   // Optional<User> findByUserName(String userName);


    Optional<User> findByEmailId(String emailId);


}
