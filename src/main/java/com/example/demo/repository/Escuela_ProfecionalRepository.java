package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Escuela_Profecional;
@Repository
public interface Escuela_ProfecionalRepository extends JpaRepository<Escuela_Profecional, Integer>{

}