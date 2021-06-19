package ru.arthur.hackathon.medicine.controller.doctor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.arthur.hackathon.medicine.controller.WebMapper;
import ru.arthur.hackathon.medicine.dao.model.Client;
import ru.arthur.hackathon.medicine.dto.UserDTO;
import ru.arthur.hackathon.medicine.service.ClientService;
import ru.arthur.hackathon.medicine.service.doctor.PatientDoctorRelationService;
import ru.arthur.hackathon.medicine.service.doctor.PatientService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor/patient")
@RequiredArgsConstructor
public class PatientController {
    private final ClientService clientService;
    private final PatientService patientService;
    private final PatientDoctorRelationService patientDoctorRelationService;
    private final WebMapper webMapper;

    @GetMapping("/find")
    public ResponseEntity<?> getClientByFIO(@RequestBody UserDTO clientDTO) {
        Client result = clientService.findClientByFIO(clientDTO.getFirstName(), clientDTO.getLastName(), clientDTO.getMiddleName());
        if(result == null) {
            return ResponseEntity.ok("Not Found");
        }
        return ResponseEntity.ok(webMapper.map(result, UserDTO.class));
    }

    @PostMapping
    public ResponseEntity<?> addPatientToDoctor(@RequestParam Long patientId) {
        patientDoctorRelationService.savePatientDoctorRelation(patientId);
        return ResponseEntity.ok("done");
    }

    @GetMapping
    public ResponseEntity<?> getAllPatientsByPage(@RequestParam(required = false, defaultValue = "0") Integer page) {
        List<UserDTO> result = webMapper.mapAll(patientService.findPatientsByPage(page), UserDTO.class);
        return ResponseEntity.ok(result);
    }
}
