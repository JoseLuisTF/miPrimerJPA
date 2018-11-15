package dao;

import connection.Conexion;
import entities.Carrera;

public class CarreraDao extends Conexion<Carrera>{
	public CarreraDao() {
		super(Carrera.class);
	}
}
