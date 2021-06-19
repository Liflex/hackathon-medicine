package ru.arthur.hackathon.medicine.dao.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Criteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;
    @OneToMany(mappedBy = "criteria", cascade = CascadeType.ALL)
    private List<CheckListCriteria> criteria;
    @OneToMany(mappedBy = "criteria", cascade = CascadeType.ALL)
    private List<CriteriaCode> codes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Criteria criteria = (Criteria) o;

        return Objects.equals(id, criteria.id);
    }

    @Override
    public int hashCode() {
        return 24742108;
    }
}
