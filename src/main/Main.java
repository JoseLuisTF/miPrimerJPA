package main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.CarreraDao;
import dao.Dao;
import dao.EstudianteDao;
import entities.Carrera;
import entities.Estudiante;

public class Main {
	public static void main(String[] args) {
		 
		Carrera c = new Carrera();
		c.setCodigo("114");
		c.setNombre("Systems3");
		c.setSemestres(10);
		c.setCreditos(152);
		
		CarreraDao dao = new CarreraDao();
		dao.insert(c);
		
		//Carrera c = dao.find("114");
		/*
		System.out.println(dao.list());
		Estudiante e = new Estudiante("1151489","peñaranda",new Date(),"male","Cristian",c);
		EstudianteDao edao = new EstudianteDao();*/
		//edao.insert(e);
		
	}
}
