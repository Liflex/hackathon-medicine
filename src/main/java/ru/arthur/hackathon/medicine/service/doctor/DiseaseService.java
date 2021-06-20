package ru.arthur.hackathon.medicine.service.doctor;

import lombok.RequiredArgsConstructor;
import ru.arthur.hackathon.medicine.dao.model.*;
import ru.arthur.hackathon.medicine.dao.repository.DiseaseRepository;
import ru.arthur.hackathon.medicine.util.AuthUtils;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiseaseService {
    private final AuthUtils authUtils;
    private final DiseaseRepository diseaseRepository;

    @Transactional(readOnly = true)
    public List<Disease> findAllDiseaseByDoctorAndClient(long clientId, Integer page) {
        Doctor doctor = (Doctor) authUtils.getCurrentUser();
        return diseaseRepository.findAllByClientIdAndDoctorId(clientId, doctor.getId(), PageRequest.of(page, 10));
    }

    @Transactional
    public Disease saveDisease(Disease disease) {
        Doctor doctor = (Doctor) authUtils.getCurrentUser();
        disease.setDoctor(doctor);
        disease.setMedicalFacility(doctor.getMedicalFacility());
        disease.setReceptions(Collections.singletonList(generateReception(disease, doctor, disease.getClient())));
        return checkDiseaseStatuse(disease);
    }

    @Transactional
    public Disease update(Disease disease) {
        if(disease.getId() == 0) throw new IllegalArgumentException("disease id is null(0)");
        Doctor doctor = (Doctor) authUtils.getCurrentUser();
        Reception reception = generateReception(disease, doctor, disease.getClient());
        disease.getReceptions().add(reception);
        return checkDiseaseStatuse(disease);
    }

    private Disease checkDiseaseStatuse(Disease disease) {
        if(disease.getDiseaseStatus() == DiseaseStatus.ILL) {
            if(disease.getCriteria() == null) throw new IllegalArgumentException("Criteria disease is null with status ILL");
        }
        return diseaseRepository.save(disease);
    }



    private Reception generateReception(Disease disease, Doctor doctor, Client client) {
        Reception reception = new Reception();
        reception.setClient(disease.getClient());
        reception.setDoctor(doctor);
        reception.setComplaint(disease.getComplaint());
        reception.setTreatment(disease.getTreatment());
        reception.setDiseaseStatus(disease.getDiseaseStatus());
        reception.setClient(client);
        return reception;
    }
}
