package ru.arthur.hackathon.medicine.dao.repository;

import ru.arthur.hackathon.medicine.dao.model.Client;
import ru.arthur.hackathon.medicine.dao.model.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findClientByUsername(String username);

    Optional<Client> findClientByFirstNameContainsAndLastNameContainsAndMiddleNameContains(String firstName, String lastName, String middleName);
}
