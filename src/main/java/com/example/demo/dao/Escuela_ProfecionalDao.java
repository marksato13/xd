package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Escuela_Profecional;

public interface Escuela_ProfecionalDao {
    Escuela_Profecional create(Escuela_Profecional escuela);
    Escuela_Profecional update(Escuela_Profecional escuela);
    void delete(int id);
    Optional<Escuela_Profecional> read(int id);
    List<Escuela_Profecional> readAll();
}
