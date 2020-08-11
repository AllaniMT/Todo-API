package com.allanimt.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {

    @Autowired
    private TokenUtility tokenUtility;

    @Autowired
    private UserService userService;


    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = {"", "/"})
    public JWTResponse signIn(@RequestBody SignInRequest signInRequest) {

        final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails user = userService.loadUserByUsername(signInRequest.getUsername());
        //System.out.println(user.getUsername());
        String token = tokenUtility.generateToken(user);
        System.out.println("***************************************"+token +"*********************************");
        JWTResponse jwtResponse = new JWTResponse(token);
        return jwtResponse;
    }
}
