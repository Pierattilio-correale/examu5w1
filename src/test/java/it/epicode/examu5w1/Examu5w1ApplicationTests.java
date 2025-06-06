package it.epicode.examu5w1;

import it.epicode.examu5w1.configuration.AppConfing;
import it.epicode.examu5w1.entities.Edificio;
import it.epicode.examu5w1.entities.Postazione;
import it.epicode.examu5w1.entities.Utente;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class Examu5w1ApplicationTests {
	private static 	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfing.class);

	@Test
	void contextLoads() {
	}
	@BeforeAll
	public static void creaContesto(){

		ctx = new AnnotationConfigApplicationContext(AppConfing.class);

	}
	@Test
	public void VerificaNomeEdificio(){
		Edificio e = ctx.getBean("edificio_a", Edificio.class);
		Assertions.assertEquals("Edificio A", e.getNome());

	}
	@Test
	public void VeirificaCittaEdificioASiaNapoli(){
		Edificio e = ctx.getBean("edificio_a", Edificio.class);
		Assertions.assertEquals("Napoli", e.getCitta());
	}

	@Test
	public void VeirificaPostazioneOpenSpaceRNumeroMassimoOccupantiSia4(){
		Postazione pos = ctx.getBean("postazione_openspace_r", Postazione.class);
		Assertions.assertEquals(4, pos.getNumeroMassimoOccupanti());
	}

	@Test
	public void VeirificaUtenteGaiaEmail(){
		Utente u1 = ctx.getBean("gaia", Utente.class);
		Assertions.assertEquals("g.bianchi@hotmail.it", u1.getEmail());
	}
	@ParameterizedTest
	@CsvSource({"gaia ,4", "luca , 4","mario , 5"})
	public void VeirificalunghezzaNomi(String nome , int num){
		Utente u1 = ctx.getBean(nome, Utente.class);

		Assertions.assertEquals(num, nome.length());
	}
	@AfterAll
	public static void chiudiContesto(){
		ctx.close();
	}

}
