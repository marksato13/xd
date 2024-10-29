package com.example.demo.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.Escuela_ProfecionalDao;
import com.example.demo.entity.Escuela_Profecional;
import com.example.demo.repository.Escuela_ProfecionalRepository;

@Component
public class Escuela_ProfecionalDaoImpl implements Escuela_ProfecionalDao {

    @Autowired
    private Escuela_ProfecionalRepository escuelaProfecionalRepository;
    
    @Override
    public Escuela_Profecional create(Escuela_Profecional escuela) {
        return escuelaProfecionalRepository.save(escuela);
    }

    @Override
    public Escuela_Profecional update(Escuela_Profecional escuela) {
        return escuelaProfecionalRepository.save(escuela);
    }

    @Override
    public void delete(int id) {
        escuelaProfecionalRepository.deleteById(id);
    }

    @Override
    public Optional<Escuela_Profecional> read(int id) {
        return escuelaProfecionalRepository.findById(id);
    }

    @Override
    public List<Escuela_Profecional> readAll() {
        return escuelaProfecionalRepository.findAll();
    }
}
