package ru.arthur.hackathon.medicine.dao.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"client_id", "doctor_id", "medical_facility_id"})
})
public class PatientDoctorRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Client client;

    @OneToOne
    private Doctor doctor;

    @OneToOne
    private MedicalFacility medicalFacility;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PatientDoctorRelation that = (PatientDoctorRelation) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 2051386866;
    }
}
