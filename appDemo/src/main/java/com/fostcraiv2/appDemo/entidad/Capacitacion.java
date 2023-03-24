package com.fostcraiv2.appDemo.entidad;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fostcraiv2.appDemo.entidad.Recreador;

@Entity
@JsonIdentityReference(alwaysAsId=true)
@Table(name="capacitaciones")
public class Capacitacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_capacitacion;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_capacitacion")
	private Date fecha_capacitacion;
	
	@Column(name = "horas_capacitacion")
	private String horas_capacitacion;
	
	public Capacitacion() {
		
	}
	
	public Capacitacion(String id_capacitacion) {
	    this.id_capacitacion = Long.parseLong(id_capacitacion);
	}

	public Capacitacion(Long id_capacitacion, Date fecha_capacitacion, String horas_capacitacion) {
		super();
		this.id_capacitacion = id_capacitacion;
		this.fecha_capacitacion = fecha_capacitacion;
		this.horas_capacitacion = horas_capacitacion;
	}

	public Long getId() {
		return id_capacitacion;
	}

	public void setId(Long id_capacitacion) {
		this.id_capacitacion = id_capacitacion;
	}

	public Date getFecha_capacitacion() {
		return fecha_capacitacion;
	}

	public void setFecha_capacitacion(Date fecha_capacitacion) {
		this.fecha_capacitacion = fecha_capacitacion;
	}

	public String getHoras_capacitacion() {
		return horas_capacitacion;
	}

	public void setHoras_capacitacion(String horas_capacitacion) {
		this.horas_capacitacion = horas_capacitacion;
	}

	@Override
	public String toString() {
		return "Capacitacion [id_capacitacion=" + id_capacitacion + ", fecha_capacitacion=" + fecha_capacitacion + ", horas_capacitacion="
				+ horas_capacitacion + "]";
	}

	
	
}
