package edu.dws.gestionMaterias200.aplicacion.DAL;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="dlk_alumno", schema="bd_gestion_material")
public class Alumno {
	
	@Id
	@Column(name="id_alumno", unique=true, nullable=false)
	@GeneratedValue( strategy= GenerationType.IDENTITY )
	private int id_alumno;
	
	@Column(name="md_uuid")
	private String md_uuid;
	
	@Column(name="md_date")
	private Calendar md_date;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="telefono")
	private String telefono;
	
	
	@OneToOne
	private Portatil portatil;
	
	

	public Alumno() {
		super();
	}

	

	public int getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}

	public String getMd_uuid() {
		return md_uuid;
	}

	public void setMd_uuid(String md_uuid) {
		this.md_uuid = md_uuid;
	}

	public Calendar getMd_date() {
		return md_date;
	}

	public void setMd_date(Calendar md_date) {
		this.md_date = md_date;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTeléfono(String telefono) {
		this.telefono = telefono;
	}

	

	public Portatil getPortatil() {
		return portatil;
	}

	public void setPortatil(Portatil portatil) {
		this.portatil = portatil;
	}
	
	

}