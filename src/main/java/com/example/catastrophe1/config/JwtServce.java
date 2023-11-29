package com.example.catastrophe1.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServce {
    private static final String SECRET_KEY = "m9AQRc0gTgxzGpEnKImpa7YS1a7wvJdPdFg+YEfAU9L3ticzBkpRJQkuYbTt1tmw61z+J8+/0znzoqGqUuwFck0o3mDEtqW6pX9Tnk9KNjBw8k5FaRO5yKrJXhw4njHY/goRRmV4XLawus2vveG+4NbMTE6ChyNrvC2BJnZTF4oAttRxt52XF4dXc4s7SFu8o/542cugDTIPWnA+LTGwI9zedVZkngeONXPN6zS4k5QxfIJCTEzzuKTorBUV/lIHCEqWWVe16nY/uraw9ImrPDtAykszUIPkxd1hvb07lq4b+azCZdUaiRaZ47yZTp3fRUJSA2Nmn7LkZO3udDg6QEh8fJB1DBFi9ZPlaA1xE5w=\n" ;
    public String extractUssername(String token) {
        return extractClaim(token , Claims::getSubject);
    }


    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>() , userDetails);
    }






    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSigningKey(), SignatureAlgorithm.ES256)
                .compact();
    }



    public boolean isTokenValid(String token, UserDetails userDetails) {

        final String username = extractUssername(token);

        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {

        return extractClaim(token ,Claims::getExpiration);

    }


    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }
}

