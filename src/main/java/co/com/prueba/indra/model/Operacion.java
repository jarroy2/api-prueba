package co.com.prueba.indra.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the operacion database table.
 * @author Jonathan Arroyo Reina
 */
@Entity()
@NamedQuery(name="Operacion.findAll", query="SELECT o FROM Operacion o")
public class Operacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	private BigDecimal numero1;

	private BigDecimal numero2;

	private BigDecimal resultado;
	

	//bi-directional many-to-one association to TipoOperacion
	@ManyToOne
	@JoinColumn(name="tipo_operacion_id")
	private TipoOperacion tipoOperacion;

	public Operacion() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public BigDecimal getNumero1() {
		return this.numero1;
	}

	public void setNumero1(BigDecimal numero1) {
		this.numero1 = numero1;
	}

	public BigDecimal getNumero2() {
		return this.numero2;
	}

	public void setNumero2(BigDecimal numero2) {
		this.numero2 = numero2;
	}

	public BigDecimal getResultado() {
		return this.resultado;
	}

	public void setResultado(BigDecimal resultado) {
		this.resultado = resultado;
	}

	public TipoOperacion getTipoOperacion() {
		return this.tipoOperacion;
	}

	public void setTipoOperacion(TipoOperacion tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	
	
	public void multiplicacion() {
		this.resultado = this.numero1.multiply(this.numero2);
	}
	
	@Transient
	public String getResultadoExacto() {
		return this.resultado.toString();
	}	
	

}