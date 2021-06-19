package ru.arthur.hackathon.medicine.util;

import lombok.RequiredArgsConstructor;
import ru.arthur.hackathon.medicine.dao.model.UserAbstract;
import ru.arthur.hackathon.medicine.service.UserService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthUtils {

    private final UserService userService;

    public UserAbstract getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return userService.loadUserByUsername(authentication.getName());
    }
}
