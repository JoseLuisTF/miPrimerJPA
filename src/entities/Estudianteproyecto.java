package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estudianteproyecto database table.
 * 
 */
@Entity
@NamedQuery(name="Estudianteproyecto.findAll", query="SELECT e FROM Estudianteproyecto e")
public class Estudianteproyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estudiante_proyecto")
	private int idEstudianteProyecto;

	private String campo;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne
	@JoinColumn(name="codigo_estudiante")
	private Estudiante estudiante;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;

	public Estudianteproyecto() {
	}

	public int getIdEstudianteProyecto() {
		return this.idEstudianteProyecto;
	}

	public void setIdEstudianteProyecto(int idEstudianteProyecto) {
		this.idEstudianteProyecto = idEstudianteProyecto;
	}

	public String getCampo() {
		return this.campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}