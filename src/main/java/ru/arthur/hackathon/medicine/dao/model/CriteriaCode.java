package ru.arthur.hackathon.medicine.dao.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "criteria_code")
@Entity
@Setter
@Getter
public class CriteriaCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CriteriaCode that = (CriteriaCode) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 1558615581;
    }
}
