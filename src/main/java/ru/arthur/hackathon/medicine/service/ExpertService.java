package ru.arthur.hackathon.medicine.service;

import lombok.RequiredArgsConstructor;
import ru.arthur.hackathon.medicine.dao.model.Client;
import ru.arthur.hackathon.medicine.dao.model.Expert;
import ru.arthur.hackathon.medicine.dao.repository.ClientRepository;
import ru.arthur.hackathon.medicine.dao.repository.ExpertRepository;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ExpertService {
    private final ExpertRepository expertRepository;

    public Expert findExpertById(long id) {
       return expertRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Expert with id not found {}", id)));
    }

    public Expert findExpertByUsername(String username) {
        return expertRepository.findExpertByUsername(username).orElseThrow(() -> new EntityNotFoundException(String.format("Expert with username not found {}", username)));
    }
}
