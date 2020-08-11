package com.allanimt.springboot.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtility {

    private final String CLAIMS_SUBJECT = "sub";
    private final String CLAIMS_CREATED = "created";

    @Value("${auth.expiration}") //if a failure appears, we have the value hard coded
    private long TOKEN_VALIDITY = 604800L; //Token stay one week valide (with second)

    @Value("${auth.secret}")
    private String TOKEN_SECRET = "mohamedTa123";

    public String generateToken(UserDetails userDetails) {

        //claims
        //expiriation
        //sign
        //compact

        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIMS_SUBJECT, userDetails.getUsername()); //In my case: E-Mail
        claims.put(CLAIMS_CREATED, new Date());

        String builder = Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, TOKEN_SECRET)
                .compact();

        return builder;
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000); // "*1000" To change the Token validty to millisecond
    }
}
