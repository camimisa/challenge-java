package com.camila.challenge.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="usuario")
public class Usuario{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int idUsuario;
	
	@Column(name="email", unique=true, nullable=false, length=100)
	private String email;
	
	@Column(name="clave", nullable=false, length=60)
	private String clave;
	@JsonIgnore
	@Column(name="enabled")
	private boolean enabled;
	@JsonIgnore
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	@JsonIgnore
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	
}
