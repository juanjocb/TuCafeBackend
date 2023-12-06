package com.registro.login.Service;

import com.registro.login.Entity.Request.UserProfileUpdateRequest;
import com.registro.login.Entity.User;
import com.registro.login.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceUser {

    private final UserRepository userRepository;



    public User getProfUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String username = authentication.getName();
            return userRepository.findByUsername(username).orElse(null);
        }
        return null;
    }

    public User updateProfileUser(String username, UserProfileUpdateRequest updateRequest) {
        User user = userRepository.findByUsername(username).orElse(null);

        if (user != null) {
            if (updateRequest.getCorreo() != null) {
                user.setCorreo(updateRequest.getCorreo());
            }

            if (updateRequest.getPassword() != null) {
                user.setPassword(updateRequest.getPassword());
            }

            userRepository.save(user);

            return user;
        } else {
            return new User("Usuario no encontrado");
        }
    }


}

