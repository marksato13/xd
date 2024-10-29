package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.Escuela_ProfecionalDto;
import com.example.demo.entity.Escuela_Profecional;

public interface Escuela_ProfecionalService <T>{
	T update(T t);
	void delete(int id);
	Optional<T> read(int id);
	List<T> readAll();
	Escuela_Profecional guardarEscuela_Profecional(Escuela_ProfecionalDto escuela_ProfecionalDto);
}	
