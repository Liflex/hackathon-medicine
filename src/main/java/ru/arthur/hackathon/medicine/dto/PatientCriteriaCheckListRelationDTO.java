package ru.arthur.hackathon.medicine.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.arthur.hackathon.medicine.dao.model.CheckListCriteria;
import ru.arthur.hackathon.medicine.dao.model.Client;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
public class PatientCriteriaCheckListRelationDTO {

    private Long id;
    private boolean done = false;
    private String commentary;
    private UserDTO client;
    private CheckListDTO criteria;

    private Date createdAt;
    private Date updatedAt;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PatientCriteriaCheckListRelationDTO that = (PatientCriteriaCheckListRelationDTO) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 2051386866;
    }
}
