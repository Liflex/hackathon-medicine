package ru.arthur.hackathon.medicine.service.doctor;

import lombok.RequiredArgsConstructor;
import ru.arthur.hackathon.medicine.dao.model.Client;
import ru.arthur.hackathon.medicine.dao.model.UserAbstract;
import ru.arthur.hackathon.medicine.dao.repository.PatientDoctorRelationRepository;
import ru.arthur.hackathon.medicine.util.AuthUtils;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientDoctorRelationRepository patientDoctorRelationRepository;
    private final AuthUtils authUtils;

    @Transactional(readOnly = true)
    public List<Client> findPatientsByPage(Integer page) {
        UserAbstract doctor = authUtils.getCurrentUser();
        return patientDoctorRelationRepository.findAllPatientByDoctor(doctor.getId(), PageRequest.of(page, 10));
    }
}
