package service.mongodb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entidades.mongodb.Contato;


public class ContatoServiceTest {

	ApplicationContext ctx;
	ContatoService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext(
				"META-INF/application-spring-mongodb-beans.xml");
		service = (ContatoService) ctx.getBean("contatoService");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testSave() {
		Contato contato = new Contato();
		contato.setNome("contato");
		contato.setEmail("email");

		Contato contatoResult = service.save(contato);

		assertNotNull(contatoResult);
	}

	@Test
	public final void testRemove() {
		Contato contato = new Contato();
		contato.setNome("contato");
		contato.setEmail("email");

		Contato contatoRemove = service.save(contato);
		service.remove(contatoRemove);

	}

	@Test
	public final void testFindById() {
		Contato contato = new Contato();
		contato.setNome("contato");
		contato.setEmail("email");

		contato = service.save(contato);

		Contato contatoFind = service.findById(contato.getId());

		assertNotNull(contatoFind);
		try {

			assertEquals(contatoFind, contato);
		} catch (AssertionError e) {
			fail("os contatos não são iguais");
		}
	}

	@Test
	public final void testFindAll() {
		List<Contato> contatos = service.list();

		assertNotNull(contatos);
	}

}
