package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the docente database table.
 * 
 */
@Entity
@NamedQuery(name="Docente.findAll", query="SELECT d FROM Docente d")
public class Docente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codigo;

	private String apellido;

	@Temporal(TemporalType.DATE)
	private Date fechanacimiento;

	private String genero;

	private String nombre;

	//bi-directional many-to-one association to Asesor
	@OneToMany(mappedBy="docente")
	private List<Asesor> asesors;

	//bi-directional many-to-one association to Carrera
	@ManyToOne
	@JoinColumn(name="codigo_carrera")
	private Carrera carrera;

	//bi-directional many-to-one association to Juradoanteproyecto
	@OneToMany(mappedBy="docente")
	private List<Juradoanteproyecto> juradoanteproyectos;

	//bi-directional many-to-one association to Juradoproyecto
	@OneToMany(mappedBy="docente")
	private List<Juradoproyecto> juradoproyectos;

	//bi-directional many-to-one association to Proyecto
	@OneToMany(mappedBy="docente")
	private List<Proyecto> proyectos;

	public Docente() {
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Asesor> getAsesors() {
		return this.asesors;
	}

	public void setAsesors(List<Asesor> asesors) {
		this.asesors = asesors;
	}

	public Asesor addAsesor(Asesor asesor) {
		getAsesors().add(asesor);
		asesor.setDocente(this);

		return asesor;
	}

	public Asesor removeAsesor(Asesor asesor) {
		getAsesors().remove(asesor);
		asesor.setDocente(null);

		return asesor;
	}

	public Carrera getCarrera() {
		return this.carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public List<Juradoanteproyecto> getJuradoanteproyectos() {
		return this.juradoanteproyectos;
	}

	public void setJuradoanteproyectos(List<Juradoanteproyecto> juradoanteproyectos) {
		this.juradoanteproyectos = juradoanteproyectos;
	}

	public Juradoanteproyecto addJuradoanteproyecto(Juradoanteproyecto juradoanteproyecto) {
		getJuradoanteproyectos().add(juradoanteproyecto);
		juradoanteproyecto.setDocente(this);

		return juradoanteproyecto;
	}

	public Juradoanteproyecto removeJuradoanteproyecto(Juradoanteproyecto juradoanteproyecto) {
		getJuradoanteproyectos().remove(juradoanteproyecto);
		juradoanteproyecto.setDocente(null);

		return juradoanteproyecto;
	}

	public List<Juradoproyecto> getJuradoproyectos() {
		return this.juradoproyectos;
	}

	public void setJuradoproyectos(List<Juradoproyecto> juradoproyectos) {
		this.juradoproyectos = juradoproyectos;
	}

	public Juradoproyecto addJuradoproyecto(Juradoproyecto juradoproyecto) {
		getJuradoproyectos().add(juradoproyecto);
		juradoproyecto.setDocente(this);

		return juradoproyecto;
	}

	public Juradoproyecto removeJuradoproyecto(Juradoproyecto juradoproyecto) {
		getJuradoproyectos().remove(juradoproyecto);
		juradoproyecto.setDocente(null);

		return juradoproyecto;
	}

	public List<Proyecto> getProyectos() {
		return this.proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public Proyecto addProyecto(Proyecto proyecto) {
		getProyectos().add(proyecto);
		proyecto.setDocente(this);

		return proyecto;
	}

	public Proyecto removeProyecto(Proyecto proyecto) {
		getProyectos().remove(proyecto);
		proyecto.setDocente(null);

		return proyecto;
	}

}