package ru.arthur.hackathon.medicine.controller;

import lombok.RequiredArgsConstructor;
import ru.arthur.hackathon.medicine.dao.model.Role;
import ru.arthur.hackathon.medicine.dto.UserDTO;
import ru.arthur.hackathon.medicine.exception.UserNotFoundException;
import ru.arthur.hackathon.medicine.service.ClientService;
import ru.arthur.hackathon.medicine.service.DoctorService;
import ru.arthur.hackathon.medicine.service.ExpertService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final ClientService clientService;
    private final ExpertService expertService;
    private final DoctorService doctorService;
    private final WebMapper webMapper;

    @GetMapping("/current")
    public ResponseEntity<?> getCurrentUser(Authentication authentication) {
        Optional<? extends GrantedAuthority> authority = authentication.getAuthorities().stream().findFirst();
        String role = authority.orElseThrow(UserNotFoundException::new).toString();
        UserDTO userDTO = null;
        if(Role.CLIENT == Role.valueOf(role)) {
            userDTO = webMapper.map(clientService.findClientByUsername(authentication.getName()), UserDTO.class);
        } else if (Role.DOCTOR == Role.valueOf(role)) {
            userDTO = webMapper.map(doctorService.findDoctorByUsername(authentication.getName()), UserDTO.class);
        } else if (Role.EXPERT == Role.valueOf(role)) {
            userDTO = webMapper.map(expertService.findExpertByUsername(authentication.getName()), UserDTO.class);
        }
        return ResponseEntity.ok(Objects.requireNonNull(userDTO));
    }
}
