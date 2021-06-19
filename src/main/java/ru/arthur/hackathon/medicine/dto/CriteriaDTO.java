package ru.arthur.hackathon.medicine.dto;

import lombok.Data;

import java.util.List;

@Data
public class CriteriaDTO {
    private List<String> codes;
    private String description;
    private List<String> criteria;
}
