package ru.arthur.hackathon.medicine.dao.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "expert")
public class Expert extends UserAbstract {
}
