package com.fostcraiv2.appDemo.entidad;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fostcraiv2.appDemo.entidad.SolicitudServicio;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@Table(name="actividades")
public class Actividad{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_actividad;
	
	@Column(name = "actividades")
	private String actividades;
	
	@Column(name = "horas")
	private int horas;	
	
	@JoinColumn(name = "id_solicitud",referencedColumnName = "id_solicitud")
	@OneToOne
	private SolicitudServicio id_solicitud;
	
	public Actividad() {
		
	}

	
	public Actividad(Long id_actividad, String actividades, int horas, SolicitudServicio id_solicitud) {
		super();
		this.id_actividad = id_actividad;
		this.actividades = actividades;
		this.horas = horas;
		this.id_solicitud = id_solicitud;
	}

	public Actividad(String actividades, int horas, SolicitudServicio id_solicitud) {
		super();
		this.actividades = actividades;
		this.horas = horas;
		this.id_solicitud = id_solicitud;
	}

	public Long getId() {
		return id_actividad;
	}

	public void setId(Long id_actividad) {
		this.id_actividad = id_actividad;
	}

	public String getActividades() {
		return actividades;
	}

	public void setActividades(String actividades) {
		this.actividades = actividades;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public SolicitudServicio getSolicitud_id() {
		return id_solicitud;
	}

	public void setSolicitud_id(SolicitudServicio id_solicitud) {
		this.id_solicitud = id_solicitud;
	}

	@Override
	public String toString() {
		return "Actividad [id_actividad=" + id_actividad + ", actividades=" + actividades + ", horas=" + horas + ", id_solicitud="
				+ id_solicitud + "]";
	}
	
	
}
