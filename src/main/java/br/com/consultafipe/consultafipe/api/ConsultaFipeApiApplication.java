package br.com.consultafipe.consultafipe.api;

import br.com.consultafipe.consultafipe.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
public class ConsultaFipeApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaFipeApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.startAplication();
	}
}
