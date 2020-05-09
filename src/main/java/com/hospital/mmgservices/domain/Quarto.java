package com.hospital.mmgservices.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Quarto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome", length = 20, nullable = true)
	private String nome;
	
	@OneToOne
	@JoinColumn(name = "statusquarto_id")
	private StatusQuarto statusquarto;
	
	 @OneToMany
	 @JoinColumn(name ="ala_id1")
	 private List<Ala> ala = new ArrayList<>(); 

	
	public Quarto () {
		
	}
}
