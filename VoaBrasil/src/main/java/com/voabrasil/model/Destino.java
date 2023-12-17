package com.voabrasil.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Destino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String cidade;
	
	@Column(nullable = false)
	private String estado;

	@OneToMany(mappedBy="destino")
	private List<Passagem> passagens;
	
	public List<Passagem> getPassagem(){
		return this.passagens;
	}
	
	public Destino(Long id, String cidade, String estado) {
		super();
		this.id = id;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Destino() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
