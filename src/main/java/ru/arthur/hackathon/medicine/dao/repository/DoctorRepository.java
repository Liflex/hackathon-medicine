package ru.arthur.hackathon.medicine.dao.repository;

import ru.arthur.hackathon.medicine.dao.model.Doctor;
import ru.arthur.hackathon.medicine.dao.model.Expert;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findDoctorByUsername(String username);
}
