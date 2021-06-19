package ru.arthur.hackathon.medicine.dao.repository;

import ru.arthur.hackathon.medicine.dao.model.Criteria;
import ru.arthur.hackathon.medicine.dao.model.UserAbstract;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CriteriaRepository extends JpaRepository<Criteria, Long> {

}
