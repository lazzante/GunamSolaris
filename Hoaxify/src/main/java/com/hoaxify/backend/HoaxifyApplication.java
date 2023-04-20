package com.hoaxify.backend;

import com.hoaxify.backend.entities.User;
import com.hoaxify.backend.repositories.UserRepository;
import com.hoaxify.backend.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;


//SPRİNG SECURITY DEVRE DIŞI BIRAKIR
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class )
@SpringBootApplication()

public class HoaxifyApplication {

    @Bean
    CommandLineRunner createInitialUsers(UserService userService){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                User user = new User();
                user.setUsername("user");
                user.setDisplayName("User");
                user.setPassword("123");
                user.setPasswordRepeat("123");
                userService.createUser(user);
            }
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(HoaxifyApplication.class, args);
    }

}
