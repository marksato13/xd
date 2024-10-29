package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Escuela_ProfecionalDao;
import com.example.demo.dao.FacultadDao;
import com.example.demo.dto.Escuela_ProfecionalDto;
import com.example.demo.entity.Escuela_Profecional;
import com.example.demo.entity.Facultad;
import com.example.demo.service.Escuela_ProfecionalService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class Escuela_ProfecionalServiceImpl implements Escuela_ProfecionalService<Escuela_Profecional> {
    
    @Autowired
    private Escuela_ProfecionalDao escuelaProfecionalDao;
    
    @Autowired
    private FacultadDao facultadDao;

    @Override
    public Escuela_Profecional update(Escuela_Profecional t) {
        return escuelaProfecionalDao.update(t);
    }

    @Override
    public void delete(int id) {
        escuelaProfecionalDao.delete(id);
    }

    @Override
    public Optional<Escuela_Profecional> read(int id) {
        return escuelaProfecionalDao.read(id);
    }

    @Override
    public List<Escuela_Profecional> readAll() {
        return escuelaProfecionalDao.readAll();
    }

    @Override
    public Escuela_Profecional guardarEscuela_Profecional(Escuela_ProfecionalDto escuela_ProfecionalDto) {
        Facultad facultad = facultadDao.read(escuela_ProfecionalDto.getFacultad())
                .orElseThrow(() -> new EntityNotFoundException("Facultad not found"));

        Escuela_Profecional escuelaProfecional = new Escuela_Profecional();
        escuelaProfecional.setNombreea(escuela_ProfecionalDto.getNombreea());
        escuelaProfecional.setFacultad(facultad);

        return escuelaProfecionalDao.create(escuelaProfecional);
    }
}
