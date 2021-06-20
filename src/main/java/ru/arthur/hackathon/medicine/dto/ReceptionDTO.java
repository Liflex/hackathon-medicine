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
import java.util.Objects;


@Data
public class ReceptionDTO {


    private Long id;
    private UserDTO client;
    private UserDTO doctor;
    private String treatment; //лечение
    private String complaint; //жалоба
    private String diseaseStatus; //Историческая хроника в случае изменения

    private Date createdAt;
    private Date updatedAt;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ReceptionDTO that = (ReceptionDTO) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 2051386866;
    }
}
