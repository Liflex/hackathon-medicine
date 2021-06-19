package ru.arthur.hackathon.medicine.dto;

import lombok.Data;

@Data
public class UserDTO {
    private long id;

    private String firstName; //Имя
    private String lastName; //Фамилия
    private String middleName; //Отчество

    private String role;
}
