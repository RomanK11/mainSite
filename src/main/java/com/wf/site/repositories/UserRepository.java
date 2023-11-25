package com.wf.site.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wf.site.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT * FROM USERS WHERE id = :id")
    Iterable<User> findUserById(@Param("id") Long id);

    User findByUsername(String username);

    @Query("SELECT * FROM USERS WHERE username = :username AND password = :password")
    Boolean findByNameAndPassword(@Param("username") String username, @Param("password") String password);
}
