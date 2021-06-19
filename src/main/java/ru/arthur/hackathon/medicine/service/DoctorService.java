package ru.arthur.hackathon.medicine.service;

import lombok.RequiredArgsConstructor;
import ru.arthur.hackathon.medicine.dao.model.Doctor;
import ru.arthur.hackathon.medicine.dao.model.Expert;
import ru.arthur.hackathon.medicine.dao.repository.DoctorRepository;
import ru.arthur.hackathon.medicine.dao.repository.ExpertRepository;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public Doctor findDoctorById(long id) {
        return doctorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Doctor with id not found {}", id)));
    }

    public Doctor findDoctorByUsername(String username) {
        return doctorRepository.findDoctorByUsername(username).orElseThrow(() -> new EntityNotFoundException(String.format("Doctor with id not found {}", username)));
    }
}
