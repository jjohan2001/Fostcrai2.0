package com.fostcraiv2.appDemo.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fostcraiv2.appDemo.entidad.Cliente;
import com.fostcraiv2.appDemo.entidad.Servicio;
import com.fostcraiv2.appDemo.entidad.Recreador;

@Entity
@JsonIdentityReference(alwaysAsId=true)
@Table(name="solcitudServicios")
public class SolicitudServicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_solicitud;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_servicio")
	private Date fecha_servicio;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
	private Cliente id_cliente;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne
	@JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
	private Servicio id_servicio;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "listaSolicitudes")
	private List<Recreador> listRec;
	
	
	
	
	public SolicitudServicio() {
		
	}

	public SolicitudServicio(String id_solicitud) {
	    this.id_solicitud = Long.parseLong(id_solicitud);
	}
	
	public SolicitudServicio(Long id_solicitud, Date fecha_servicio, Cliente id_cliente, Servicio id_servicio,
			List<Recreador> listRec) {
		super();
		this.id_solicitud = id_solicitud;
		this.fecha_servicio = fecha_servicio;
		this.id_cliente = id_cliente;
		this.id_servicio = id_servicio;
		this.listRec = listRec;
	}

	public Long getId() {
		return id_solicitud;
	}

	public void setId(Long id_solicitud) {
		this.id_solicitud = id_solicitud;
	}

	public Date getFecha_servicio() {
		return fecha_servicio;
	}

	public void setFecha_servicio(Date fecha_servicio) {
		this.fecha_servicio = fecha_servicio;
	}

	public Cliente getId_cliente_fk() {
		return id_cliente;
	}

	public void setId_cliente_fk(Cliente id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Servicio getId_servicio_fk() {
		return id_servicio;
	}

	public void setId_servicio_fk(Servicio id_servicio) {
		this.id_servicio = id_servicio;
	}

	public List<Recreador> getListRec() {
		return listRec;
	}

	public void setListRec(List<Recreador> listRec) {
		this.listRec = listRec;
	}

	@Override
	public String toString() {
		return "SolicitudServicio [id_solicitud=" + id_solicitud + ", fecha_servicio=" + fecha_servicio + ", id_cliente=" + id_cliente
				+ ", id_servicio=" + id_servicio + ", listRec=" + listRec + "]";
	}

	

}
