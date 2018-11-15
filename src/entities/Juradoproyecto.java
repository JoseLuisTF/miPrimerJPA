package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the juradoproyecto database table.
 * 
 */
@Entity
@NamedQuery(name="Juradoproyecto.findAll", query="SELECT j FROM Juradoproyecto j")
public class Juradoproyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date fechaasignacion;

	@Temporal(TemporalType.DATE)
	private Date fechanota;

	private float nota;

	@Lob
	private String observacion;

	//bi-directional many-to-one association to Docente
	@ManyToOne
	@JoinColumn(name="codigo_docente")
	private Docente docente;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	public Juradoproyecto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaasignacion() {
		return this.fechaasignacion;
	}

	public void setFechaasignacion(Date fechaasignacion) {
		this.fechaasignacion = fechaasignacion;
	}

	public Date getFechanota() {
		return this.fechanota;
	}

	public void setFechanota(Date fechanota) {
		this.fechanota = fechanota;
	}

	public float getNota() {
		return this.nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}