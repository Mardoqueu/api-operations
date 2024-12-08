package com.challenge.operations.service;

import com.challenge.operations.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * CustomUserDetailsService is a Spring service that implements the
 * UserDetailsService interface to provide user-specific data used
 * in authentication and authorization processes.
 *
 * It relies on an injected UserService to retrieve user information
 * from a data source based on the username provided.
 *
 * Responsibilities:
 * - Load user details by a specific username.
 * - Verify the existence of the user.
 * - Transform the User entity to a Spring Security compatible
 *   UserDetails object with appropriate authorities.
 *
 * This service throws a UsernameNotFoundException if the user is not
 * found, ensuring that authentication can be handled correctly within
 * a Spring Security context.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with name: " + username);
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
