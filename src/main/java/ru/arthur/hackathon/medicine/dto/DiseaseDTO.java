package ru.arthur.hackathon.medicine.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.arthur.hackathon.medicine.dao.model.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
public class DiseaseDTO {

    private Long id;

    private UserDTO client;
    private UserDTO doctor;
    private MedicalFacilityDTO medicalFacility;

    private String treatment; //Рекомендации лечения. При сохранении сохраняется в завершенный (новый) прием
    private String complaint; //Жалобы пациента. При сохранении сохраняется в завершенный (новый)  прием
    private String diseaseStatus;

    private CriteriaDTOOut criteria;
    private List<ReceptionDTO> receptions;
    private List<PatientCriteriaCheckListRelationDTO> checkList; //Здесь хранятся отчеты по проделанным процедурам


    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DiseaseDTO that = (DiseaseDTO) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 2051386866;
    }
}
