package ru.arthur.hackathon.medicine.dao.repository;

import ru.arthur.hackathon.medicine.dao.model.Criteria;
import ru.arthur.hackathon.medicine.dao.model.UserAbstract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CriteriaRepository extends JpaRepository<Criteria, Long> {
    List<Criteria> findAllByDescriptionContains(String lineText, Pageable page);
}
