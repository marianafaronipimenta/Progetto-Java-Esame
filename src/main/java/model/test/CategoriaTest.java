package test_model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Categoria;

/**
 * Test per la classe Categoria.
 * 
 * Verifica che il contenuto del campo nome sia valido e lancia eccezioni se
 * l'utente ha inserito un contenuto nullo o una stringa vuota. Inoltre l'ultimo
 * test verifica che se sono presenti due categorie inserite col medesimo nome,
 * allora sono uguali.
 * 
 * @author Gibello
 */

class CategoriaTest {

	@Test
	void testValidInsertion() {

		Categoria n = new Categoria("Spesa alimentare");

		assertEquals("Spesa alimentare", n.getNome());

	}

	@Test
	void testNullNameThrowsException() {

		assertThrows(IllegalArgumentException.class, () -> new Categoria(null));

	}

	@Test
	void testEmptyNameThrowsException() {

		assertThrows(IllegalArgumentException.class, () -> new Categoria(""));

	}

	@Test
	void testCategorieUguali() {

		Categoria n1 = new Categoria("Ikea");
		Categoria n2 = new Categoria("Ikea");

		assertTrue(n1.equals(n2));

	}
}
