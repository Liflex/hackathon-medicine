package ru.arthur.hackathon.medicine.dto;

import lombok.Data;
import ru.arthur.hackathon.medicine.dao.model.CriticalLevel;

@Data
public class AnalyticsDTO {
    private UserDTO doctor;
    private DiseaseDTO disease;
    private CriticalLevel criticalLevel;
}
