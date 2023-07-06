package com.App.Vaccination.repo;

import com.App.Vaccination.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(
            value = "select password from user where username = :username",
            nativeQuery = true
    )
    public String findPassword(String username);

    @Query(
            value = "select * from user where username = :username",
            nativeQuery = true
    )
    public User findByUsername(String username);

}
