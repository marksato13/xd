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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="ESCUELA_PROFECIONAL")
public class Escuela_Profecional {
	@Id
	@Column(name = "ID_ESCUELA_PROFECIONAL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEscuela_Profecional")
    @SequenceGenerator(name = "seqEscuela_Profecional", allocationSize = 1, sequenceName = "SEQ_ESCUELA_PROFECIONAL")
    private Integer id;
	
	@Column(name = "NOMBRE_EA")
	@NotNull @NotBlank    
    private String nombreea;
	
	
//TODO RELACIONES 	
    @ManyToOne
    @JoinColumn(name = "ID_FACULTAD", nullable = false)
    private Facultad facultad;
    
    
}
