package ru.arthur.hackathon.medicine.dao.model;

public enum DiseaseStatus {
    ILL, //БОЛЕЕТ
    CONSULTATION, //Консультация (единоразовый приём)
    RECOVERED, //Выздоровел (Закрытие приёма)
    IDENTIFICATIONOFTHEDIAGNOSIS //(открытия начала серии приёмов)
}
