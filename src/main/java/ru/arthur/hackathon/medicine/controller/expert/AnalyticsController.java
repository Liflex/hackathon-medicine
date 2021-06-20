package ru.arthur.hackathon.medicine.controller.expert;

import lombok.RequiredArgsConstructor;
import ru.arthur.hackathon.medicine.controller.WebMapper;
import ru.arthur.hackathon.medicine.dao.model.Client;
import ru.arthur.hackathon.medicine.dto.AnalyticsDTO;
import ru.arthur.hackathon.medicine.dto.UserDTO;
import ru.arthur.hackathon.medicine.service.ClientService;
import ru.arthur.hackathon.medicine.service.analitycs.AnalyticsService;
import ru.arthur.hackathon.medicine.service.doctor.PatientDoctorRelationService;
import ru.arthur.hackathon.medicine.service.doctor.PatientService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expert/analytics")
@RequiredArgsConstructor
public class AnalyticsController {
    private final AnalyticsService analyticsService;
    private final WebMapper webMapper;

    @GetMapping
    public ResponseEntity<?> getAnalytics() {
        List<AnalyticsDTO> analyticsDTOS = analyticsService.generateNotFakeAnalytics();
        return ResponseEntity.ok(analyticsDTOS);
    }


}
