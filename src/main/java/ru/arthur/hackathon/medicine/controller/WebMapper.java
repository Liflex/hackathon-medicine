package ru.arthur.hackathon.medicine.controller;

import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WebMapper extends ModelMapper {
    public <T, S> List<T> mapAll(List<S> list, Class<T> target) {
        return list.stream().map(i -> super.map(i, target))
                .collect(Collectors.toList());
    }
}
