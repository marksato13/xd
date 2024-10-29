package com.example.demo.entity;



import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="FACULTAD")
public class Facultad {
	@Id
	@Column(name = "ID_FACULTAD")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFacultad")
    @SequenceGenerator(name = "seqFacultad", allocationSize = 1, sequenceName = "SEQ_FACULTAD")
    private Integer id;
	
	@Column(name = "NOMBRE_FACULTAD")
	@NotNull @NotBlank    
    private String nombre_facultad;

//TODO RELACIONES 	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "facultad")
	@JsonIgnore
	private Set<Escuela_Profecional> escuela_profecional;
}
