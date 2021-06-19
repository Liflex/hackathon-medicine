package ru.arthur.hackathon.medicine.service;

import lombok.RequiredArgsConstructor;
import ru.arthur.hackathon.medicine.dao.model.Client;
import ru.arthur.hackathon.medicine.dao.model.UserAbstract;
import ru.arthur.hackathon.medicine.dao.repository.UserAuthRepository;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UserService {
private final UserAuthRepository userAuthRepository;

    public UserAbstract loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAuthRepository.findUserAbstractByUsername(username).orElseThrow(() -> new EntityNotFoundException(String.format("Username {}, not found", username)));
    }
}
