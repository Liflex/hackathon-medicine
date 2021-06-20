package ru.arthur.hackathon.medicine.dto;

import lombok.Data;

import javax.persistence.*;

@Data
public class MedicalFacilityDTO {
    private Long id;
    private String name;
}
