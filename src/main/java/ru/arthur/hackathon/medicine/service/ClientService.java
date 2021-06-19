package ru.arthur.hackathon.medicine.service;

import lombok.RequiredArgsConstructor;
import ru.arthur.hackathon.medicine.dao.model.Client;
import ru.arthur.hackathon.medicine.dao.repository.ClientRepository;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client findClientById(long id) {
       return clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Client with id not found {}", id)));
    }

    public Client findClientByUsername(String username) {
        return clientRepository.findClientByUsername(username).orElseThrow(() -> new EntityNotFoundException(String.format("Client with username not found {}", username)));
    }

    public Client findClientByFIO(String firstName, String lastName, String middleName) {
        return clientRepository.findClientByFirstNameContainsAndLastNameContainsAndMiddleNameContains
                (firstName, lastName, middleName).orElse(null);
    }
}
