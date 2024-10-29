package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FacultadDao;
import com.example.demo.entity.Facultad;
import com.example.demo.service.FacultadService;

@Service
public class FacultadServiceImpl implements FacultadService<Facultad> {
    
    @Autowired
    private FacultadDao facultadDao;

    @Override
    public Facultad create(Facultad t) {
        return facultadDao.create(t);
    }

    @Override
    public Facultad update(Facultad t) {
        return facultadDao.update(t);
    }

    @Override
    public void delete(int id) {
        facultadDao.delete(id);
    }

    @Override
    public Optional<Facultad> read(int id) {
        return facultadDao.read(id);
    }

    @Override
    public List<Facultad> readAll() {
        return facultadDao.readAll();
    }
}
