package com.tep.pucmm.ValoracionComputadora;

import com.tep.pucmm.ValoracionComputadora.Servicios.UsuarioService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ValoracionComputadoraApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(ValoracionComputadoraApplication.class, args);

		UsuarioService usuarioService = (UsuarioService)appContext.getBean("usuarioService");
		usuarioService.crearAdmin();
	}
}
