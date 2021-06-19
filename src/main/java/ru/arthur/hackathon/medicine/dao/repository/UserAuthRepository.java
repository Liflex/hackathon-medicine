package ru.arthur.hackathon.medicine.dao.repository;

import ru.arthur.hackathon.medicine.dao.model.UserAbstract;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthRepository extends JpaRepository<UserAbstract, Long> {
    Optional<UserAbstract> findUserAbstractByUsername(String username);
}
