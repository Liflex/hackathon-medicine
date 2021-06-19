package ru.arthur.hackathon.medicine.service;

import lombok.RequiredArgsConstructor;
import ru.arthur.hackathon.medicine.dao.model.Criteria;
import ru.arthur.hackathon.medicine.dao.repository.CriteriaRepository;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CriteriaService {

    private final CriteriaRepository criteriaRepository;

    public void save(Criteria criteria) {
        criteriaRepository.save(criteria);
    }

    public List<Criteria> findCriteriaByContainsDescription(String lineText) {
        return criteriaRepository.findAllByDescriptionContains(lineText, PageRequest.of(0, 10));
    }
}
