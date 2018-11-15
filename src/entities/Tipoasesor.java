package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipoasesor database table.
 * 
 */
@Entity
@NamedQuery(name="Tipoasesor.findAll", query="SELECT t FROM Tipoasesor t")
public class Tipoasesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String descripcion;

	//bi-directional many-to-one association to Asesor
	@OneToMany(mappedBy="tipoasesor")
	private List<Asesor> asesors;

	public Tipoasesor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Asesor> getAsesors() {
		return this.asesors;
	}

	public void setAsesors(List<Asesor> asesors) {
		this.asesors = asesors;
	}

	public Asesor addAsesor(Asesor asesor) {
		getAsesors().add(asesor);
		asesor.setTipoasesor(this);

		return asesor;
	}

	public Asesor removeAsesor(Asesor asesor) {
		getAsesors().remove(asesor);
		asesor.setTipoasesor(null);

		return asesor;
	}

}