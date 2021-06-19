package ru.arthur.hackathon.medicine.dao.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "check_list_criteria")
@Entity
@Setter
@Getter
public class CheckListCriteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "text")
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CheckListCriteria that = (CheckListCriteria) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 1558615581;
    }
}
