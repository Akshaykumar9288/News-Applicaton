package com.Search_Engine.News_Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Search_Engine.News_Application.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.email = :email")
    public User findByEmail(@Param("email") String email);

}
