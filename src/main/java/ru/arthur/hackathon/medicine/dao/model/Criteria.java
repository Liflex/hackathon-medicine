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

    @Column(columnDefinition = "text")
    private String description;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "check_list_criteria_relation")
    private List<CheckListCriteria> criteriaCheckList;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "code_criteria_relation")
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
