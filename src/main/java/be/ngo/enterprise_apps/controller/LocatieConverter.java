package be.ngo.enterprise_apps.controller;

import be.ngo.enterprise_apps.model.Locatie;
import be.ngo.enterprise_apps.repository.LocatieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LocatieConverter implements Converter<String, Locatie> {

    @Autowired
    private LocatieRepository locatieRepository;

    @Override
    public Locatie convert(String id) {
        if (id == null || id.isBlank()) return null;
        return locatieRepository.findById(Long.parseLong(id)).orElse(null);
    }
}
