package com.allanimt.springboot.util;

import com.allanimt.springboot.security.AppUser;
import com.allanimt.springboot.security.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FirstTimeInitializer implements CommandLineRunner {

    private final Log logger = LogFactory.getLog(FirstTimeInitializer.class);

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {

        //Checking if there is users
        //if not create some users
        if (userService.findAll().isEmpty()) {
            logger.info("There is no user exist, created some users");

            AppUser appUser = new AppUser("MohamedTayeb.Allani@Syncwork.de", "Mohamed", "Passowrd");
            userService.save(appUser);
        }
    }
}
