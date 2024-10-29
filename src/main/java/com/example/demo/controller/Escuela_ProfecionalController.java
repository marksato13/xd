package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Escuela_ProfecionalDto;
import com.example.demo.entity.Escuela_Profecional;
import com.example.demo.serviceImpl.Escuela_ProfecionalServiceImpl;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.example.demo.ApiEndpoints.ApiEndpoints.API_ESCUELAPROFECIONAL;

@RestController
@RequestMapping(API_ESCUELAPROFECIONAL)
@CrossOrigin({"*"})

public class Escuela_ProfecionalController {
	@Autowired
	private Escuela_ProfecionalServiceImpl escuela_ProfecionalServiceImpl;
	
	
	@GetMapping("/ListEscu")
	public ResponseEntity<List<Escuela_Profecional>> listar() {
		try {
		      List<Escuela_Profecional> alq = escuela_ProfecionalServiceImpl.readAll();
		      if (alq.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	@GetMapping("BuscarEscu/{id}")
	public ResponseEntity<Escuela_Profecional> getEscuela_ProfecionalById(@PathVariable("id") int id){
		Optional<Escuela_Profecional> carData = escuela_ProfecionalServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Escuela_Profecional>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@PostMapping("/InsertEscu")
    public ResponseEntity<Escuela_Profecional> crear(@Valid @RequestBody Escuela_ProfecionalDto escuela_ProfecionalDto){
        try {
        	Escuela_Profecional _alq = escuela_ProfecionalServiceImpl.guardarEscuela_Profecional(escuela_ProfecionalDto);
            return new ResponseEntity<Escuela_Profecional>(_alq, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
	

	@DeleteMapping("DeleteEscu/{id}")
	public ResponseEntity<Escuela_Profecional> delete(@PathVariable("id") int id){
		try {
			escuela_ProfecionalServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	
	@PutMapping("EdidEscu/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @Valid @RequestBody Escuela_Profecional escuela){
		Optional<Escuela_Profecional> carData = escuela_ProfecionalServiceImpl.read(id);
	      if (carData.isPresent()) {
	    	  Escuela_Profecional dbescuela = carData.get();
	    	  dbescuela.setNombreea(escuela.getNombreea());
	        
	        return new ResponseEntity<Escuela_Profecional>(escuela_ProfecionalServiceImpl.update(dbescuela), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}