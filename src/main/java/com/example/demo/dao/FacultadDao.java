package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Facultad;

public interface FacultadDao {
    Facultad create(Facultad facultad);
    Facultad update(Facultad facultad);
    void delete(int id);
    Optional<Facultad> read(int id);
    List<Facultad> readAll();
}
