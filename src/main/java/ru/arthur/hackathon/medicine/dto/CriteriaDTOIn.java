package ru.arthur.hackathon.medicine.dto;

import lombok.Data;

import java.util.List;

@Data
public class CriteriaDTOIn {
    private List<String> codes;
    private String description;
    private List<String> criteria;
}
