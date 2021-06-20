package ru.arthur.hackathon.medicine.service.analitycs;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import ru.arthur.hackathon.medicine.controller.WebMapper;
import ru.arthur.hackathon.medicine.dao.model.*;
import ru.arthur.hackathon.medicine.dao.repository.CriteriaRepository;
import ru.arthur.hackathon.medicine.dto.*;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AnalyticsService {
    private final CriteriaRepository criteriaRepository;
    private final WebMapper webMapper;

    private Faker faker = new Faker();
    public List<AnalyticsDTO> generateNotFakeAnalytics() {
        List<AnalyticsDTO> analyticsDTOS = new ArrayList<>();

        for (int i = 0; i < 200; i++) {
            AnalyticsDTO analyticsDTO = new AnalyticsDTO();
            analyticsDTO.setDoctor(getFakeUser());
            analyticsDTO.setCriticalLevel(getRandomCritical());
            analyticsDTO.setDisease(getRandomDisease());
            analyticsDTOS.add(analyticsDTO);
        }
        return analyticsDTOS;
    }

    private UserDTO getFakeUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(faker.name().firstName());
        userDTO.setLastName(faker.name().lastName());
        userDTO.setMiddleName(faker.name().nameWithMiddle());
        return userDTO;
    }

    private CriticalLevel getRandomCritical() {
        int i = new Random().nextInt(3);
        if(i == 1) return CriticalLevel.MEDIUM;
        else if(i == 2) return CriticalLevel.HIGH;
        else if(i == 0) return CriticalLevel.LOW;
        return null;
    }

    private DiseaseDTO getRandomDisease() {
        DiseaseDTO diseaseDTO = new DiseaseDTO();
        diseaseDTO.setClient(getFakeUser());
        List<Criteria> all = criteriaRepository.findAll();
        Criteria criteria = all.get(new Random().nextInt(all.size()));
        diseaseDTO.setCriteria(webMapper.map(criteria, CriteriaDTOOut.class));
        diseaseDTO.setTreatment(faker.commerce().productName());
        diseaseDTO.setComplaint(faker.educator().university());
        List<PatientCriteriaCheckListRelationDTO> check = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            check.add(getRandom());
        }
        diseaseDTO.setCheckList(check);
        return diseaseDTO;
    }

    private PatientCriteriaCheckListRelationDTO getRandom() {
        PatientCriteriaCheckListRelationDTO patientCriteriaCheckListRelationDTO = new PatientCriteriaCheckListRelationDTO();
        patientCriteriaCheckListRelationDTO.setCommentary(faker.chuckNorris().fact());
        patientCriteriaCheckListRelationDTO.setDone(new Random().nextBoolean());
        return patientCriteriaCheckListRelationDTO;
    }
}
