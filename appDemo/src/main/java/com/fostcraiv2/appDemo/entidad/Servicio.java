package com.fostcraiv2.appDemo.entidad;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="servicios")
public class Servicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_servicio;
	
	@Column(name = "nombre_servicio")
	private String nombre_servicio;
	
	@Column(name = "valor")
	private int valor;
	
	@OneToMany(mappedBy = "id_solicitud")
	private List<SolicitudServicio> ListSol;
	
	public Servicio() {
		
	}

	
	
	public Servicio(Long id_servicio, String nombre_servicio, int valor, List<SolicitudServicio> listSol) {
		super();
		this.id_servicio = id_servicio;
		this.nombre_servicio = nombre_servicio;
		this.valor = valor;
		ListSol = listSol;
	}

	public Servicio(String nombre_servicio, int valor, List<SolicitudServicio> listSol) {
		super();
		this.nombre_servicio = nombre_servicio;
		this.valor = valor;
		ListSol = listSol;
	}


	public Long getId() {
		return id_servicio;
	}

	public void setId(Long id_servicio) {
		this.id_servicio = id_servicio;
	}

	public String getNombre_servicio() {
		return nombre_servicio;
	}

	public void setNombre_servicio(String nombre_servicio) {
		this.nombre_servicio = nombre_servicio;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public List<SolicitudServicio> getListSol() {
		return ListSol;
	}

	public void setListSol(List<SolicitudServicio> listSol) {
		ListSol = listSol;
	}

	@Override
	public String toString() {
		return "Servicio [id_servicio=" + id_servicio + ", nombre_servicio=" + nombre_servicio + ", valor=" + valor + ", ListSol="
				+ ListSol + "]";
	}
	
}
