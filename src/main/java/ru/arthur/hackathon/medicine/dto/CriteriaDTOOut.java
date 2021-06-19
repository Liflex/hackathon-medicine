package ru.arthur.hackathon.medicine.dto;

import lombok.Data;

import java.util.List;

@Data
public class CriteriaDTOOut {
    private List<String> codes;
    private String description;
    private List<String> criteria;
}
