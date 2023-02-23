package edu.dws.gestionMaterias200.web.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.dws.gestionMaterias200.aplicacion.DAL.Portatil;
import edu.dws.gestionMaterias200.aplicacion.DAL.PortatilRepositorio;


@Service
public class Consultas {
	
	
	@Autowired
	private PortatilRepositorio portatilR;
	
	
	
	public void InsertarPortatil(Portatil portatil) {
		portatilR.save(portatil);
	}
}
