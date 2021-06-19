package ru.arthur.hackathon.medicine.controller;

import lombok.RequiredArgsConstructor;
import ru.arthur.hackathon.medicine.dao.model.CheckListCriteria;
import ru.arthur.hackathon.medicine.dao.model.Criteria;
import ru.arthur.hackathon.medicine.dao.model.CriteriaCode;
import ru.arthur.hackathon.medicine.dto.CriteriaDTOIn;
import ru.arthur.hackathon.medicine.dto.CriteriaDTOOut;
import ru.arthur.hackathon.medicine.dto.FinderContainer;
import ru.arthur.hackathon.medicine.service.CriteriaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/criteria")
@RequiredArgsConstructor
public class CriteriaController {

    private final CriteriaService criteriaService;
    private final WebMapper webMapper;

    @PostMapping
    public ResponseEntity<?> saveNewCriteriaList(@RequestBody List<CriteriaDTOIn> criteria) {
        List<Criteria> collect = convertCriteriaDTOToEntity(criteria);
        collect.forEach(criteriaService::save);
        return ResponseEntity.ok("OK");
    }

    private List<Criteria> convertCriteriaDTOToEntity(List<CriteriaDTOIn> criteria) {
        List<Criteria> collect = criteria.stream().map(x -> {
            List<CheckListCriteria> listCriteria = x.getCriteria().stream().map(criteriaStream -> {
                CheckListCriteria checkListCriteria = new CheckListCriteria();
                checkListCriteria.setDescription(criteriaStream);
                return checkListCriteria;
            }).collect(Collectors.toList());
            List<CriteriaCode> codeList = x.getCodes().stream().map(code -> {
                CriteriaCode criteriaCode = new CriteriaCode();
                criteriaCode.setCode(code);
                return criteriaCode;
            }).collect(Collectors.toList());

            Criteria criteria1 = new Criteria();
            criteria1.setCriteriaCheckList(listCriteria);
            criteria1.setCodes(codeList);
            criteria1.setDescription(x.getDescription());
            return criteria1;
        }).collect(Collectors.toList()); return collect;
    }

    @GetMapping("/find")
    public ResponseEntity<?> findCriteriaByContainsText(@RequestBody FinderContainer container) {
        List<Criteria> criteriaByContainsDescription = criteriaService.findCriteriaByContainsDescription(container.getText());
        List<CriteriaDTOOut> result = webMapper.mapAll(criteriaByContainsDescription, CriteriaDTOOut.class);
        return ResponseEntity.ok(result);
    }
}
