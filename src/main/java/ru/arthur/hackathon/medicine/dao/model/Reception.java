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
public class Reception {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Client client;

    @OneToOne
    private Doctor doctor;

    private String treatment; //лечение

    private String complaint; //жалоба

    @Enumerated(EnumType.STRING)
    private DiseaseStatus diseaseStatus; //Историческая хроника в случае изменения


    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Reception that = (Reception) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 2051386866;
    }
}
