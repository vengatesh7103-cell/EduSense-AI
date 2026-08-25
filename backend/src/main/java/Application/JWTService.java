package Application;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

	    @Value("${app.jwt.secret}")
	    private String secret;

	    @Value("${app.jwt.expiration}")
	    private long jwtExpiration;

	    private Key getSigningKey() {
	        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
	    }

	    public String generateToken(String email) {

	        return Jwts.builder()
	                .subject(email)
	                .issuedAt(new Date())
	                .expiration(new Date(System.currentTimeMillis() + jwtExpiration))
	                .signWith(getSigningKey())
	                .compact();
	    }

	    public String extractEmail(String token) {
	        return extractAllClaims(token).getSubject();
	    }

	    public boolean isTokenValid(String token, String email) {
	        String username = extractEmail(token);
	        return username.equals(email) && !isTokenExpired(token);
	    }

	    private boolean isTokenExpired(String token) {
	        return extractAllClaims(token).getExpiration().before(new Date());
	    }

	    private Claims extractAllClaims(String token) {

	        return Jwts.parser()
	                .verifyWith((javax.crypto.SecretKey) getSigningKey())
	                .build()
	                .parseSignedClaims(token)
	                .getPayload();
	    }
	}
