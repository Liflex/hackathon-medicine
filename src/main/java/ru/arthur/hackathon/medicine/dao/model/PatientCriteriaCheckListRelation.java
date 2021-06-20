package ru.arthur.hackathon.medicine.dao.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
public class PatientCriteriaCheckListRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean done = false;

    @Column(columnDefinition = "text")
    private String commentary;

    @OneToOne
    private Client client;

    @OneToOne
    private CheckListCriteria criteria;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PatientCriteriaCheckListRelation that = (PatientCriteriaCheckListRelation) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 2051386866;
    }
}
