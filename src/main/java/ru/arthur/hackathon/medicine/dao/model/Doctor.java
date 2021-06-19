package ru.arthur.hackathon.medicine.dao.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "doctor")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Doctor extends UserAbstract {

    @OneToOne
    private MedicalFacility medicalFacility;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Doctor doctor = (Doctor) o;

        return Objects.equals(getId(), doctor.getId());
    }

    @Override
    public int hashCode() {
        return 232737213;
    }
}
