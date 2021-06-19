package ru.arthur.hackathon.medicine.dto;

import lombok.Data;

@Data
public class CheckListDTO {
    private long id;
    private String description;
    private Boolean done = false;
}
