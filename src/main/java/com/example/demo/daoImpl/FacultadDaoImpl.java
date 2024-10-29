package com.example.demo.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.FacultadDao;
import com.example.demo.entity.Facultad;
import com.example.demo.repository.FacultadRepository;

@Component
public class FacultadDaoImpl implements FacultadDao {

    @Autowired
    private FacultadRepository facultadRepository;
    
    @Override
    public Facultad create(Facultad facultad) {
        return facultadRepository.save(facultad);
    }

    @Override
    public Facultad update(Facultad facultad) {
        return facultadRepository.save(facultad);
    }

    @Override
    public void delete(int id) {
        facultadRepository.deleteById(id);
    }

    @Override
    public Optional<Facultad> read(int id) {
        return facultadRepository.findById(id);
    }

    @Override
    public List<Facultad> readAll() {
        return facultadRepository.findAll();
    }
}
