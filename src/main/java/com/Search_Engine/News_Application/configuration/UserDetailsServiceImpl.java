package com.Search_Engine.News_Application.configuration;

import com.Search_Engine.News_Application.Repository.UserRepository;
import com.Search_Engine.News_Application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByEmail(username);
        if (user == null){
            throw new UsernameNotFoundException("Could not found User");
        }

        CustomUser customUser = new CustomUser(user);
        return customUser;
    }
}
