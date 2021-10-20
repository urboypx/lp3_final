package br.ifsul.jogodaforca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import br.ifsul.jogodaforca.model.PalavraRepository;
import br.ifsul.jogodaforca.ui.UIAdicionar;
import br.ifsul.jogodaforca.ui.UIRelatorio;

@SpringBootApplication
public class Main {

	@Autowired
	public PalavraRepository palavraRepository;

	public static void main(String[] args) {
		SpringApplicationBuilder sab = new SpringApplicationBuilder(Main.class);

		sab.headless(false);

		ConfigurableApplicationContext app = sab.run(args);

		Main instancia = (Main) app.getBean("main");

		// UIMain uim = new UIMain();
		// uim.setVisible(true);

		// UIRelatorio uir = new UIRelatorio(instancia.palavraRepository);
		// uir.setVisible(true);
		
		UIAdicionar uia = new UIAdicionar();
		uia.setVisible(true);
	}

}
