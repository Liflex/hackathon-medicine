package ru.arthur.hackathon.medicine.controller;

import lombok.RequiredArgsConstructor;
import ru.arthur.hackathon.medicine.dao.model.Criteria;
import ru.arthur.hackathon.medicine.dto.CriteriaDTO;
import ru.arthur.hackathon.medicine.service.CriteriaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/criteria")
@RequiredArgsConstructor
public class CriteriaController {

    private final CriteriaService criteriaService;
    private final WebMapper webMapper;

    @PostMapping
    public ResponseEntity<?> saveNewCriteriaList(@RequestBody List<CriteriaDTO> criteria) {
        List<Criteria> targetList = webMapper.mapAll(criteria, Criteria.class);
        targetList.forEach(criteriaService::save);
        return ResponseEntity.ok("OK");
    }

    @GetMapping
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("OK");
    }
}
