package com.challenge.operations.jwt;

import com.challenge.operations.service.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * The JwtRequestFilter class extends the OncePerRequestFilter to execute
 * filtering logic once per request within a Spring application. This filter
 * intercepts incoming HTTP requests to extract and validate a JWT token from
 * the Authorization header. If a valid token is found, it sets the authentication
 * in the security context for further processing by the application.
 *
 * The filter primarily performs the following tasks:
 *
 * 1. Extracts the JWT token from the Authorization header of the HTTP request,
 *    if present and prefixed with "Bearer ".
 *
 * 2. Utilizes the JwtUtil component to extract the username and validate the token.
 *
 * 3. Loads the user details using the CustomUserDetailsService based on the extracted
 *    username.
 *
 * 4. If the token is valid, creates a UsernamePasswordAuthenticationToken and sets it
 *    in the SecurityContextHolder to complete the authentication process.
 *
 * This class enables stateless authentication where each request can be validated
 * independently, based on the JWT token it carries.
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            username = jwtUtil.extractUsername(jwt);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);

            if (jwtUtil.validateToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        chain.doFilter(request, response);
    }
}
