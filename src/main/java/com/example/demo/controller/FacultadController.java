package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Facultad;
import com.example.demo.serviceImpl.FacultadServiceImpl;

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

import static com.example.demo.ApiEndpoints.ApiEndpoints.API_FACULTAD;

@RestController
@RequestMapping(API_FACULTAD)
@CrossOrigin({"*"})

public class FacultadController {
	@Autowired
	private FacultadServiceImpl facultadServiceImpl;
	
	
	@GetMapping("/ListFacul")
	public ResponseEntity<List<Facultad>> listar() {
		try {
		      List<Facultad> alq = facultadServiceImpl.readAll();
		      if (alq.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	@GetMapping("BuscarFacul/{id}")
	public ResponseEntity<Facultad> getEquipoById(@PathVariable("id") int id){
		Optional<Facultad> carData = facultadServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Facultad>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@PostMapping("/InsertFacul")
    public ResponseEntity<Facultad> crear(@Valid @RequestBody Facultad facultad){
        try {
        	Facultad _alq = facultadServiceImpl.create(facultad);
            return new ResponseEntity<Facultad>(_alq, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
	

	@DeleteMapping("DeleteFacul/{id}")
	public ResponseEntity<Facultad> delete(@PathVariable("id") int id){
		try {
			facultadServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	
	@PutMapping("EdidFacul/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @Valid @RequestBody Facultad facultad){
		Optional<Facultad> carData = facultadServiceImpl.read(id);
	      if (carData.isPresent()) {
	    	  Facultad dbequipo = carData.get();
	    	  dbequipo.setNombre_facultad(facultad.getNombre_facultad());
	 
	        
	        return new ResponseEntity<Facultad>(facultadServiceImpl.update(dbequipo), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}