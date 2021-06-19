package ru.arthur.hackathon.medicine.dao.repository;

import ru.arthur.hackathon.medicine.dao.model.Expert;
import ru.arthur.hackathon.medicine.dao.model.UserAbstract;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpertRepository extends JpaRepository<Expert, Long> {
    Optional<Expert> findExpertByUsername(String username);
}
