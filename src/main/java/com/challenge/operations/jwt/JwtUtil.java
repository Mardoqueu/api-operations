package com.challenge.operations.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

/**
 * Utility class for managing JSON Web Tokens (JWTs). This class provides
 * methods to extract information from JWT tokens and validate them.
 *
 * It utilizes a secret key to parse and validate JWTs, ensuring they have
 * not expired and are issued for the expected user.
 *
 * Configurations:
 * - The secret key used for signing and parsing tokens is injected from
 *   the application properties using the key `jwt.secret`.
 *
 * Methods:
 * - extractUsername: Extracts the username from the specified JWT.
 * - extractExpiration: Retrieves the expiration date from the JWT.
 * - extractClaim: General method to extract a specific claim from the JWT
 *   using a provided function to resolve the claims.
 * - validateToken: Validates the JWT by checking its username against the
 *   expected user and ensuring it has not expired.
 */
@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
