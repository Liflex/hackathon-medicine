package ru.arthur.hackathon.medicine.dao.repository;

import ru.arthur.hackathon.medicine.dao.model.Client;
import ru.arthur.hackathon.medicine.dao.model.PatientDoctorRelation;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PatientDoctorRelationRepository extends JpaRepository<PatientDoctorRelation, Long> {

    @Query("select pr.client from PatientDoctorRelation pr where pr.doctor.id = ?1")
    List<Client> findAllPatientByDoctor(long doctorId, Pageable pageable);
}
