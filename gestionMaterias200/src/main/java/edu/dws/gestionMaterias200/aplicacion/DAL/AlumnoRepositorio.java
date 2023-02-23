package edu.dws.gestionMaterias200.aplicacion.DAL;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AlumnoRepositorio extends CrudRepository<Alumno, Integer> {

}
