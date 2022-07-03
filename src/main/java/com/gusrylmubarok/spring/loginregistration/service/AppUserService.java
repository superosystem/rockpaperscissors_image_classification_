package com.gusrylmubarok.spring.loginregistration.service;

import com.gusrylmubarok.spring.loginregistration.entity.AppUser;
import com.gusrylmubarok.spring.loginregistration.repository.AppUserRepository;
import com.gusrylmubarok.spring.loginregistration.entity.ConfirmationToken;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    private final static String USER_NOT_FOUND_MSG = "User with email %s not found!";
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    /*
    ** Load user detail with username
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG)));
    }
    /*
    ** Sign Up User
     */
    public String signUpUser(AppUser appUser) {
        // Check user email.
        boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
        if (userExists) {
            // TODO Check of attributes are the same and if email not confirmed send confirmation email.
            throw new IllegalStateException("email is already taken!");
        }
        // Ecoded user password.
        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
        // Save user value
        appUserRepository.save(appUser);
        // Generate token for user
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), appUser);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        // TODO : Send to email.
        return token;
    }
    /*
     ** Set Enabled User
     */
    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }
}
