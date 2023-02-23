package edu.dws.gestionMaterias200.web.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.dws.gestionMaterias200.aplicacion.DAL.Portatil;
import edu.dws.gestionMaterias200.web.servicios.Consultas;


@Controller
public class ControladorPortatil {
	@Autowired
	private Consultas consulta;
	Map<String,Object> modelo = new HashMap<String,Object>();
	List<Portatil> listaPortatiles = new ArrayList<>();
	 protected final Log logger = LogFactory.getLog(getClass());
	 
	 
	 @RequestMapping(value="/Formulario")
	 public String navegacion(Model modelo) {
		 
		 Portatil portatil = new Portatil();
		 modelo.addAttribute("portatil", portatil);
		 
		 
		return "Formulario";
		 
	 }
	 @RequestMapping(value="/guardarAlumno",method = RequestMethod.POST)
	 public ModelAndView guardarPortatil(@ModelAttribute("portatil") Portatil portatil) {
		 
		 listaPortatiles.add(portatil);
		 modelo.put("portatil", listaPortatiles);
		 consulta.InsertarPortatil(portatil);
		 
		 
		return new ModelAndView("Listar","modelo",modelo);
		 
		 
	 }
}
