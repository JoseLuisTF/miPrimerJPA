package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the asesor database table.
 * 
 */
@Entity
@NamedQuery(name="Asesor.findAll", query="SELECT a FROM Asesor a")
public class Asesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Docente
	@ManyToOne
	@JoinColumn(name="codigo_docente")
	private Docente docente;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	//bi-directional many-to-one association to Tipoasesor
	@ManyToOne
	@JoinColumn(name="id_tipo")
	private Tipoasesor tipoasesor;

	public Asesor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Tipoasesor getTipoasesor() {
		return this.tipoasesor;
	}

	public void setTipoasesor(Tipoasesor tipoasesor) {
		this.tipoasesor = tipoasesor;
	}

}