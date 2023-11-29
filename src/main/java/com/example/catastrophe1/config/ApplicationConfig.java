package com.example.catastrophe1.config;

import com.example.catastrophe1.repository.UtilisateurRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UtilisateurRepo repo ;

    @Bean
    public UserDetailsService userDetailsService (){
        return username -> repo.findByEmail(username)
               .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    }


}
