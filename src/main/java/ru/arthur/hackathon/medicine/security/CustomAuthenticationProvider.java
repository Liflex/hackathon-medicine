package ru.arthur.hackathon.medicine.security;

import lombok.RequiredArgsConstructor;
import ru.arthur.hackathon.medicine.dao.model.UserAbstract;
import ru.arthur.hackathon.medicine.service.UserService;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserAbstract userAbstract = userService.loadUserByUsername(name);

        if (checkingPasswords(password, userAbstract.getPassword())) {
            // use the credentials
            // and authenticate against the third-party system
            return new UsernamePasswordAuthenticationToken(
                    name, password, userAbstract.getAuthorities());
        } else {
            throw new BadCredentialsException("External system authentication failed");
        }
    }

    private boolean checkingPasswords(String password1, String password2) {
        return passwordEncoder.matches(password1, password2);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
