package co.com.prueba.indra.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tipo_operacion database table.
 * 
 */
@Entity
@Table(name="tipo_operacion")
@NamedQuery(name="TipoOperacion.findAll", query="SELECT t FROM TipoOperacion t")
public class TipoOperacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="fecha_actualizacion")
	private Timestamp fechaActualizacion;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	private String nombre;

	private String simbolo;

	//bi-directional many-to-one association to Operacion
	@JsonIgnore
	@OneToMany(mappedBy="tipoOperacion")
	private List<Operacion> operacions;

	public TipoOperacion() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Timestamp fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSimbolo() {
		return this.simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public List<Operacion> getOperacions() {
		return this.operacions;
	}

	public void setOperacions(List<Operacion> operacions) {
		this.operacions = operacions;
	}

	public Operacion addOperacion(Operacion operacion) {
		getOperacions().add(operacion);
		operacion.setTipoOperacion(this);

		return operacion;
	}

	public Operacion removeOperacion(Operacion operacion) {
		getOperacions().remove(operacion);
		operacion.setTipoOperacion(null);

		return operacion;
	}

}