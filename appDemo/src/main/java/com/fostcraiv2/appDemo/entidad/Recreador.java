package com.fostcraiv2.appDemo.entidad;

import java.util.Date;
import java.util.List;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import com.fostcraiv2.appDemo.entidad.SolicitudServicio;
import com.fostcraiv2.appDemo.entidad.Usuario;
import com.fostcraiv2.appDemo.entidad.Contrato;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fostcraiv2.appDemo.entidad.Capacitacion;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@Table(name="recreadores")
public class Recreador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_recreador;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_nacimiento")
	private Date fecha_nacimiento;
	
	@Column(name = "edad")
	private int edad;

	@ManyToMany()
	@JoinTable(name = "programacionRec",
			joinColumns=@JoinColumn(name = "id_recreador", nullable=false),
			inverseJoinColumns=@JoinColumn(name = "id_solicitud", nullable=false))
	private List<SolicitudServicio> listaSolicitudes;
	
	
	@JoinColumn(name = "id_usuario", unique=true)
	@OneToOne
	private Usuario id_usuario;
	
	
	@ManyToOne
	@JoinColumn(name = "id_capacitacion", referencedColumnName = "id_capacitacion")
	private Capacitacion id_capacitacion;
	

	public Recreador() {
		
	}


	public Recreador(Long id_recreador, Date fecha_nacimiento, int edad, List<SolicitudServicio> listaSolicitudes,
			Usuario id_usuario, Capacitacion id_capacitacion) {
		super();
		this.id_recreador = id_recreador;
		this.fecha_nacimiento = fecha_nacimiento;
		this.edad = edad;
		this.listaSolicitudes = listaSolicitudes;
		this.id_usuario = id_usuario;
		this.id_capacitacion = id_capacitacion;
	}

	public Recreador(Date fecha_nacimiento, int edad, List<SolicitudServicio> listaSolicitudes,
			Usuario id_usuario, Capacitacion id_capacitacion) {
		super();
		this.fecha_nacimiento = fecha_nacimiento;
		this.edad = edad;
		this.listaSolicitudes = listaSolicitudes;
		this.id_usuario = id_usuario;
		this.id_capacitacion = id_capacitacion;
	}


	public Long getId() {
		return id_recreador;
	}


	public void setId(Long id_recreador) {
		this.id_recreador = id_recreador;
	}


	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public List<SolicitudServicio> getListaSolicitudes() {
		return listaSolicitudes;
	}


	public void setListaSolicitudes(List<SolicitudServicio> listaSolicitudes) {
		this.listaSolicitudes = listaSolicitudes;
	}


	public Usuario getId_usuario_fk() {
		return id_usuario;
	}


	public void setId_usuario_fk(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}


	public Capacitacion getId_capacitacion_fk() {
		return id_capacitacion;
	}


	public void setId_capacitacion_fk(Capacitacion id_capacitacion) {
		this.id_capacitacion = id_capacitacion;
	}


	@Override
	public String toString() {
		return "Recreador [id_recreador=" + id_recreador + ", fecha_nacimiento=" + fecha_nacimiento + ", edad=" + edad
				+ ", listaSolicitudes=" + listaSolicitudes + ", id_usuario_fk=" + id_usuario
				+ ", id_capacitacion=" + id_capacitacion + "]";
	}
	
}
