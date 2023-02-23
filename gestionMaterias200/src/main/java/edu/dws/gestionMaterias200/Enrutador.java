package edu.dws.gestionMaterias200;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


import edu.dws.gestionMaterias200.web.WebConfiguracionContexto;



public class Enrutador extends AbstractAnnotationConfigDispatcherServletInitializer {

	

		   @Override
		    protected Class<?>[] getRootConfigClasses() {
		        return new Class<?>[] { WebConfiguracionContexto.class };
		    }

		    @Override
		    protected Class<?>[] getServletConfigClasses() {
		        return new Class<?>[] { WebConfiguracionContexto.class };
		    }

		    @Override
		    protected String[] getServletMappings() {
		        return new String[] { "/" };
		    }

	}

