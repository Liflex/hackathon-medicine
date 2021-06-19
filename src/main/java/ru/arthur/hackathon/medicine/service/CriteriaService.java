package ru.arthur.hackathon.medicine.service;

import lombok.RequiredArgsConstructor;
import ru.arthur.hackathon.medicine.dao.model.Criteria;
import ru.arthur.hackathon.medicine.dao.model.UserAbstract;
import ru.arthur.hackathon.medicine.dao.repository.CriteriaRepository;
import ru.arthur.hackathon.medicine.dao.repository.UserAuthRepository;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class CriteriaService {

    private final CriteriaRepository criteriaRepository;

    public void save(Criteria criteria) {
        criteriaRepository.save(criteria);
    }
}
