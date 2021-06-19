package ru.arthur.hackathon.medicine.service.doctor;

import lombok.RequiredArgsConstructor;
import ru.arthur.hackathon.medicine.dao.model.Client;
import ru.arthur.hackathon.medicine.dao.model.Doctor;
import ru.arthur.hackathon.medicine.dao.model.PatientDoctorRelation;
import ru.arthur.hackathon.medicine.dao.repository.ClientRepository;
import ru.arthur.hackathon.medicine.dao.repository.PatientDoctorRelationRepository;
import ru.arthur.hackathon.medicine.util.AuthUtils;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class PatientDoctorRelationService {
    private final PatientDoctorRelationRepository patientDoctorRelationRepository;
    private final AuthUtils utils;

    @Transactional
    public void savePatientDoctorRelation(Long clientId) {
        PatientDoctorRelation patientDoctorRelation = new PatientDoctorRelation();
        patientDoctorRelation.setDoctor((Doctor) utils.getCurrentUser());
        patientDoctorRelation.setMedicalFacility(((Doctor) utils.getCurrentUser()).getMedicalFacility());
        Client client = new Client();
        client.setId(clientId);
        patientDoctorRelation.setClient(client);
        patientDoctorRelationRepository.save(patientDoctorRelation);
    }
}
