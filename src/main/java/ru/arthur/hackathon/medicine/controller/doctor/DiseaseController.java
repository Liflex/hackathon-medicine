package ru.arthur.hackathon.medicine.controller.doctor;

import lombok.RequiredArgsConstructor;
import ru.arthur.hackathon.medicine.controller.WebMapper;
import ru.arthur.hackathon.medicine.dao.model.*;
import ru.arthur.hackathon.medicine.dto.DiseaseDTO;
import ru.arthur.hackathon.medicine.dto.UserDTO;
import ru.arthur.hackathon.medicine.service.ClientService;
import ru.arthur.hackathon.medicine.service.doctor.DiseaseService;
import ru.arthur.hackathon.medicine.service.doctor.PatientDoctorRelationService;
import ru.arthur.hackathon.medicine.service.doctor.PatientService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor/disease")
@RequiredArgsConstructor
public class DiseaseController {
    private final WebMapper webMapper;
    private final DiseaseService diseaseService;

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        Disease disease = new Disease();
        Doctor doctor = new Doctor();
        doctor.setId(1L);
        disease.setDoctor(doctor);
        Client client = new Client();
        client.setId(3L);
        disease.setClient(client);

        disease.setDiseaseStatus(DiseaseStatus.ILL);
        disease.setComplaint("Жалобаааа клиента");
        disease.setTreatment("рекомендация лечения");
        Criteria criteria = new Criteria();
        criteria.setId(167L);
        disease.setCriteria(criteria);

        return ResponseEntity.ok(webMapper.map(disease, DiseaseDTO.class));
    }

    @PostMapping
    public ResponseEntity<?> createDisease(@RequestBody DiseaseDTO diseaseDTO) {
        Disease result = webMapper.map(diseaseDTO, Disease.class);
        result = diseaseService.saveDisease(result);
        return ResponseEntity.ok(webMapper.map(result, DiseaseDTO.class));
    }

    @PutMapping
    public ResponseEntity<?> updateDisease(@RequestBody DiseaseDTO diseaseDTO) {
        Disease result = webMapper.map(diseaseDTO, Disease.class);
        result = diseaseService.update(result);
        return ResponseEntity.ok(webMapper.map(result, DiseaseDTO.class));
    }

    @GetMapping
    public ResponseEntity<?> findAllPage(@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam Long clientId) {
        List<DiseaseDTO> result = webMapper.mapAll(diseaseService.findAllDiseaseByDoctorAndClient(clientId, page), DiseaseDTO.class);
        return ResponseEntity.ok(result);
    }
}
